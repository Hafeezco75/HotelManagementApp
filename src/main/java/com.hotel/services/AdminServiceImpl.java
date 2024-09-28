package com.hotel.services;

import com.hotel.Dto.ReservationDto;
import com.hotel.Dto.Response;
import com.hotel.data.Reservation.Reservation;
import com.hotel.data.models.Guest;
import com.hotel.data.models.Room;
import com.hotel.data.repository.AdminRepository;
import com.hotel.data.repository.ReservationRepository;
import com.hotel.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public Response addRoom(Room room) {
//        if(room exist){
//            throw new MainException("Room already exist");
//        }
        roomRepository.save(room);
        return new Response();
    }

    @Override
    public void updateRoom(Room room) {
        roomRepository.findByRoom(room.id);
//        Update then save
        roomRepository.save(room);

    }

    @Override
    public List<Room> viewAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Reservation> viewAllBookings() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getBookingDetails(ReservationDto reservationDto) {
        return null;
    }

    @Override
    public void cancelBooking(ReservationDto reservationDto) {

    }

    @Override
    public List<Guest> getAllGuests() {
        return List.of();
    }
}
