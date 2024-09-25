package com.hotel.data.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Room {
        @Id
        private Long id;
        private String name;
        private boolean status;
        private BigDecimal price;
        private String description;
        private String image;
        private String type;
}
