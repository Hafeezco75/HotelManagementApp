package com.hotel.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long reservationId;
    private String reservationNumber;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Rooms rooms;

}
