package com.hotel.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetReservationResponse {
    private Long reservationId;
    private String message;
}
