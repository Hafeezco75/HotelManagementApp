package com.hotel.data.repository;

import com.hotel.Dto.ReservationDto;
import com.hotel.data.Reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(ReservationDto reservationDto);
}
