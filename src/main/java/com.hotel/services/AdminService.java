package com.hotel.services;

import com.hotel.Dto.ReservationDto;
import com.hotel.data.Reservation.Reservation;
import com.hotel.data.models.Guest;
import com.hotel.data.models.Room;

import java.util.List;

public interface AdminService {

    void addRoom(Room room);
    void updateRoom(Room room);
    List<Room> viewAllRooms();
    List<Reservation> viewAllBookings();
    Reservation getBookingDetails(ReservationDto reservationDto);
    void cancelBooking(ReservationDto reservationDto);
    List<Guest> getAllGuests();
}
