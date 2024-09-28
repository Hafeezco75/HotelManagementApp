package com.hotel.controller;

import com.hotel.Dto.ReservationDto;
import com.hotel.data.models.Room;
import com.hotel.data.models.User;
import com.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // Room Management services for admin

    @PostMapping("/add-room")
    public ResponseEntity<String> addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
        return ResponseEntity.ok("Room added successfully!");
    }

    @PutMapping("/update-room")
    public ResponseEntity<String> updateRoom(@RequestBody Room room) {
        roomService.updateRoom(roomId, room);
        return ResponseEntity.ok("Room updated successfully!");
    }

    @DeleteMapping("/delete-room")
    public ResponseEntity<String> deleteRoom(@RequestBody roomDto roomId) {
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

    @GetMapping("/booking")
    public ResponseEntity<Reservation> getBookingDetails(@PathVariable Long bookingId) {
        Reservation booking = bookingService.getBookingDetails(bookingId);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/cancel-booking")
    public ResponseEntity<String> cancelBooking(@RequestBody ReservationDto reservationDto) {
        bookingService.cancelBooking(reservationDto);
        return ResponseEntity.ok("Booking canceled successfully!");
    }

    // Guest Management
    @GetMapping("/guests")
    public List<User> viewAllGuests() {
        return userService.getAllGuests();
    }

    @GetMapping("/find-guest")
    public ResponseEntity<User> getGuestDetails(@RequestBody GuestDto guestDto) {
        User guest = userService.getGuestById(guestDto);
        return ResponseEntity.ok(guest);
    }

    @DeleteMapping("/delete-guest")
    public ResponseEntity<String> deleteGuest(@RequestBody GuestDto guestDto) {
        userService.deleteGuest(guestId);
        return ResponseEntity.ok("Guest deleted successfully!");
    }

}
