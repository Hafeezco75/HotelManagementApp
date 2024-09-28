package com.hotel.dtos.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateReservationResponse {
    private String reservationNumber;
    private String message;

}
