package com.hotel.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long roomId;
    private String name;
    private String roomNumber;
    private BigDecimal roomPrice;
    private String roomImage;
    private String roomDescription;
    private String roomCapacity;
    @ManyToOne
    private Reservation reservation;

}
