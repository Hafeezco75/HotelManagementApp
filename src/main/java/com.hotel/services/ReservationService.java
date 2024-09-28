package com.hotel.services;

import com.hotel.data.models.Reservation;
import com.hotel.dtos.requests.CreateReservationRequest;
import com.hotel.dtos.requests.DeleteReservationRequest;
import com.hotel.dtos.requests.GetReservationRequest;
import com.hotel.dtos.response.CreateReservationResponse;
import com.hotel.dtos.response.DeleteReservationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    CreateReservationResponse createReservation(CreateReservationRequest createRequest);

    DeleteReservationResponse deleteReservation(DeleteReservationRequest deleteRequest);

    List<Reservation> getAllReservations(GetReservationRequest getRequest);
}
