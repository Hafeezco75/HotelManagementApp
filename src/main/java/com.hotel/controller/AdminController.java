package com.hotel.controller;

import com.hotel.Dto.GuestDto;
import com.hotel.Dto.ReservationDto;
import com.hotel.data.models.Room;
import com.hotel.data.models.User;
import com.hotel.services.AdminService;
import com.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Room Management services for admin

    @PostMapping("/add-room")
    public ResponseEntity<String> addRoom(@RequestBody Room room) {
        adminService.addRoom(room);
        return ResponseEntity.ok("Room added successfully!");
    }

    @PutMapping("/update-room")
    public ResponseEntity<String> updateRoom(@RequestBody Room room) {
        adminService.updateRoom(room);
        return ResponseEntity.ok("Room updated successfully!");
    }

    @DeleteMapping("/delete-room")
    public ResponseEntity<String> deleteRoom(@RequestBody roomDto roomId) {
        adminService.deleteRoom(roomId);
        return ResponseEntity.ok("Room deleted successfully!");
    }

    @GetMapping("/rooms")
    public List<Room> viewAllRooms() {
        return adminService.getAllRooms();
    }

    // Booking Management

    @GetMapping("/bookings")
    public ResponseEntity<?> viewAllBookings() {
        return ResponseEntity.ok(adminService.viewAllBookings());
    }

    @GetMapping("/booking")
    public ResponseEntity<?> getBookingDetails(@RequestBody ReservationDto reservationDto) {
        Reservation booking = adminService.getBookingDetails(reservationDto);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/cancel-booking")
    public ResponseEntity<String> cancelBooking(@RequestBody ReservationDto reservationDto) {
        adminService.cancelBooking(reservationDto);
        return ResponseEntity.ok("Booking canceled successfully!");
    }

    // Guest Management
    @GetMapping("/guests")
    public ResponseEntity<?> viewAllGuests() {
        return ResponseEntity.ok(adminService.getAllGuests());
    }

    @GetMapping("/find-guest")
    public ResponseEntity<User> getGuestDetails(@RequestBody GuestDto guestDto) {
        User guest = adminService.getAllGuests(guestDto);
        return ResponseEntity.ok(guest);
    }

    @DeleteMapping("/delete-guest")
    public ResponseEntity<String> deleteGuest(@RequestBody GuestDto guestDto) {
        adminService.deleteGuest(guestDto);
        return ResponseEntity.ok("Guest deleted successfully!");
    }

}
