package com.hotel.services;

import com.hotel.Dto.ReservationDto;
import com.hotel.data.models.Guest;
import com.hotel.data.repository.GuestRepository;
import com.hotel.data.repository.ReservationRepository;
import com.hotel.data.Reservation.Reservation;
import com.hotel.exception.MainException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GuestRepository guestRepository;


    @Override
    public Response registerGuest(Guest guest) {
        Optional<Guest> optionalGuest = guestRepository.findByUsername(guest.getUsername());
        if(optionalGuest.isPresent()){
            throw new MainException("Guest already exist");
        }
        guestRepository.save(guest);
        return new Response();
    }

    @Override
    public Response bookRoom(Reservation reservation) {
//        add your bookroom method here, import your room class and call the book room here

        Response response = new Response();
        response.setMessage("Room booked successfully");
        return response;
    }

    @Override
    public void cancelBooking(ReservationDto reservation) {
        reservationRepository.deleteById(reservation.getId());
    }
}
