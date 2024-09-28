package com.hotel.services;

import com.hotel.Dto.ReservationDto;
import com.hotel.Dto.Response;
import com.hotel.data.Reservation.Reservation;
import com.hotel.data.models.Guest;

public interface GuestService {
    Response registerGuest(Guest guest);
    Response bookRoom(Reservation reservation);
    void cancelBooking(ReservationDto reservation);
}
