package com.hotel.dtos.requests;

import com.hotel.data.models.Rooms;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class CreateReservationRequest {
    private Long reservationId;
    private String reservationNumber;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private List<Rooms> rooms;

}
