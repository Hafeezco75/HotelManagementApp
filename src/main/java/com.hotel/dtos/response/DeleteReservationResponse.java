package com.hotel.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteReservationResponse {
    private String jwtToken;
    private String message;
    private List<String> roles;

}
