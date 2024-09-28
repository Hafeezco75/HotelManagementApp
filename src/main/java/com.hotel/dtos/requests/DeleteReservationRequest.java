package com.hotel.dtos.requests;

import com.hotel.data.models.Rooms;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteReservationRequest {
    private String reservationNumber;
    private Rooms rooms;
}
