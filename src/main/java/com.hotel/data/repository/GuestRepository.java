package com.hotel.data.repository;

import com.hotel.data.models.Guest;
import com.hotel.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByUsername(String username);
}
