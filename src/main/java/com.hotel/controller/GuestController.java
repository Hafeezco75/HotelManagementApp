package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private final JwtUtil jwtUtil;

    @Autowired
    private final RoomService room;

    @Autowired// Service to handle room-related operations
    private final ReservationService reservation; // Service to handle booking operations



    @GetMapping("/available-rooms")
    public List<Room> viewAvailableRooms(@RequestParam String checkInDate, @RequestParam String checkOutDate) {
        return room.getAvailableRooms(checkInDate, checkOutDate);
    }

    @PostMapping("/book-room")
    public ResponseEntity<String> bookRoom(@RequestHeader(value = "Authorization") String authorizationHeader,
                                           @RequestBody ReservationRequestDto bookingRequest) {
        validateAuthorizationHeader(authorizationHeader);
        String token = extractToken(authorizationHeader);
        String username = jwtUtil.extractUsername(token);

        reservation.bookRoom(username, bookingRequest);
        return ResponseEntity.ok("Room booked successfully!");
    }

    @DeleteMapping("/cancel-booking/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId,
                                                @RequestHeader(value = "Authorization") String authorizationHeader) {
        validateAuthorizationHeader(authorizationHeader);
        String token = extractToken(authorizationHeader);
        String username = jwtUtil.extractUsername(token);

        reservation.cancelBooking(username, bookingId);
        return ResponseEntity.ok("Booking canceled successfully!");
    }

    private void validateAuthorizationHeader(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Unauthorized: Missing or invalid Authorization header");
        }
    }

    private String extractToken(String authorizationHeader) {
        return authorizationHeader.substring(7); // Remove "Bearer "
    }
}

