package com.hotel.controller;

import com.hotel.Utils.JwtUtil;
import com.hotel.data.Reservation.Reservation;
import com.hotel.data.models.Room;
import com.hotel.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;



    @PostMapping("/registerGuest")
    public ResponseEntity<String> registerGuest(@RequestBody Reservation request) {
        guestService.bookRoom(request);
        return ResponseEntity.ok("Room booked successfully!");
    }


    @PostMapping("/book-room")
    public ResponseEntity<String> bookRoom(@RequestBody Reservation request) {
        guestService.bookRoom(request);
        return ResponseEntity.ok("Room booked successfully!");
    }

    @DeleteMapping("/cancel-booking")
    public ResponseEntity<String> cancelBooking(RequestBody ReservationDto reservation) {
        guestService.cancelBooking(reservation);
        return ResponseEntity.ok("Booking canceled successfully!");
    }

}

