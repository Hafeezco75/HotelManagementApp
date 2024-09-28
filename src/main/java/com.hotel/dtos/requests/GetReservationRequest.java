package com.hotel.dtos.requests;


import com.hotel.data.models.Rooms;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class GetReservationRequest {
    private Long reservationId;
    private String reservationNumber;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private List<Rooms> rooms;
}
