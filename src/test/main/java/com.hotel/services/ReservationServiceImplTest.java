package com.hotel.services;

import com.hotel.data.models.Reservation;
import com.hotel.data.models.Rooms;
import com.hotel.data.repositories.ReservationRepository;
import com.hotel.dtos.requests.CreateReservationRequest;
import com.hotel.dtos.requests.GetReservationRequest;
import com.hotel.dtos.response.CreateReservationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservationServiceImplTest {

    @Autowired
    ReservationService reservationService;


    @Test
    public void testThatAdminCanCreateReservation() {
        CreateReservationRequest reservationRequest = new CreateReservationRequest();
        reservationRequest.setReservationNumber("B5C439543D");
        reservationRequest.setReservationStartDate(LocalDate.of(2021,3,13));
        reservationRequest.setReservationEndDate(LocalDate.of(2023,3,14));
        reservationRequest.setRooms(List.of(new Rooms()));
        CreateReservationResponse createResponse = reservationService.createReservation(reservationRequest);
        assertThat(createResponse).isNotNull();
        assertThat(createResponse.getMessage()).isEqualTo("Reservation details created successfully");
        assertThat(createResponse.getReservationNumber()).isEqualTo(123);
    }

    @Test
    public void testThatAdminCanGetReservation() {
        GetReservationRequest getReservationRequest = new GetReservationRequest();
        getReservationRequest.setReservationNumber("E5426DAWES");
        List<Reservation> reservation = reservationService.getAllReservations(getReservationRequest);
        reservation.set(1, new Reservation());
        assertThat(reservation).isNotNull();
        assertThat(reservation.size()).isEqualTo(1);
        assertThat(reservation.getFirst().getReservationId()).isEqualTo(123);
    }

}





