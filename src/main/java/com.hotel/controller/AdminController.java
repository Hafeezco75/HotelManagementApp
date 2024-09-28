package com.hotel.controller;

import com.hotel.data.models.User;
import com.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private final RoomService roomService; // Service to manage rooms

    @Autowired
    private final ReservationService bookingService; // Service to manage bookings

    @Autowired
    private UserService userService;




    // Room Management services for admin

    @PostMapping("/add-room")
    public ResponseEntity<String> addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
        return ResponseEntity.ok("Room added successfully!");
    }

    @PutMapping("/update-room/{roomId}")
    public ResponseEntity<String> updateRoom(@PathVariable Long roomId, @RequestBody Room room) {
        roomService.updateRoom(roomId, room);
        return ResponseEntity.ok("Room updated successfully!");
    }

    @DeleteMapping("/delete-room/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.ok("Room deleted successfully!");
    }

    @GetMapping("/rooms")
    public List<Room> viewAllRooms() {
        return roomService.getAllRooms();
    }

    // Booking Management

    @GetMapping("/bookings")
    public List<Reservation> viewAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Reservation> getBookingDetails(@PathVariable Long bookingId) {
        Reservation booking = bookingService.getBookingDetails(bookingId);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/cancel-booking/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok("Booking canceled successfully!");
    }

    // Guest Management
    @GetMapping("/guests")
    public List<User> viewAllGuests() {
        return userService.getAllGuests();
    }

    @GetMapping("/guest/{guestId}")
    public ResponseEntity<User> getGuestDetails(@PathVariable Long guestId) {
        User guest = userService.getGuestById(guestId);
        return ResponseEntity.ok(guest);
    }

    @DeleteMapping("/delete-guest/{guestId}")
    public ResponseEntity<String> deleteGuest(@PathVariable Long guestId) {
        userService.deleteGuest(guestId);
        return ResponseEntity.ok("Guest deleted successfully!");
    }

}
