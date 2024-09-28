package com.hotel.services;

import com.hotel.data.models.Reservation;
import com.hotel.data.repositories.ReservationRepository;
import com.hotel.dtos.requests.CreateReservationRequest;
import com.hotel.dtos.requests.DeleteReservationRequest;
import com.hotel.dtos.requests.GetReservationRequest;
import com.hotel.dtos.response.CreateReservationResponse;
import com.hotel.dtos.response.DeleteReservationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public CreateReservationResponse createReservation(CreateReservationRequest createRequest) {
        validateReservation(createRequest);
        Reservation reservations = new Reservation();
        reservations.setReservationNumber(createRequest.getReservationNumber());
        reservations.setReservationStartDate(createRequest.getReservationStartDate());
        reservations.setReservationEndDate(createRequest.getReservationEndDate());
        reservationRepository.save(reservations);

        CreateReservationResponse createResponse = new CreateReservationResponse();
        createResponse.setReservationNumber(createRequest.getReservationNumber());
        createResponse.setMessage("Reservation details created successfully");
        return createResponse;
    }


    private void validateReservation(CreateReservationRequest createRequest) {
        String reservationNumber = createRequest.getReservationNumber();

        for (Reservation reservation : reservationRepository.findAll()) {
            if (reservation.getReservationNumber().equals(reservationNumber)) {
                throw new RuntimeException("Reservation Number already exists");
            }else {
                reservation.setReservationNumber(reservationNumber);
            }
        }
    }

    @Override
    public DeleteReservationResponse deleteReservation(DeleteReservationRequest deleteRequest) {
        DeleteReservationResponse deleteResponse = new DeleteReservationResponse();
        String reservationNumber = deleteRequest.getReservationNumber();

        //Reservation reservations = reservationRepository.findReservationBy(reservationNumber);
        for (Reservation reservations : reservationRepository.findAll()){
            if (reservations.getReservationNumber().equals(reservationNumber)) {
                reservationRepository.delete(reservations);
            } else {
                throw new RuntimeException("Reservation Number does not exist");
            }
        }

        deleteResponse.setMessage("Reservation successfully deleted");
        return deleteResponse;
    }


    @Override
    public List<Reservation> getAllReservations(GetReservationRequest getRequest) {
        for (Reservation reservation : reservationRepository.findAll()) {
            if (reservation.getReservationNumber().equals(getRequest.getReservationNumber())) {
                return reservationRepository.findAll();
            }else {
                throw new RuntimeException("Reservation Number is not valid");
            }
        }
        return null;
    }

}
