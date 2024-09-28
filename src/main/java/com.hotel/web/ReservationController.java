package com.hotel.web;

import com.hotel.dtos.requests.CreateReservationRequest;
import com.hotel.dtos.requests.DeleteReservationRequest;
import com.hotel.dtos.response.ApiResponse;
import com.hotel.dtos.response.CreateReservationResponse;
import com.hotel.dtos.response.DeleteReservationResponse;
import com.hotel.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController("")
@RequestMapping("/v1")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
       @PreAuthorize("hasRole('ADMIN')")
       public ResponseEntity<?> createReservation(CreateReservationRequest createRequest) {
           try {
               CreateReservationResponse response = reservationService.createReservation(createRequest);
               return new ResponseEntity<>(response, HttpStatus.CREATED);
           }catch (Exception e) {
                return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
           }
       }

       @DeleteMapping("/delete")
       public ResponseEntity<?> deleteReservation(@RequestBody DeleteReservationRequest deleteRequest) {

           try {
               DeleteReservationResponse response = reservationService.deleteReservation(deleteRequest);
               return new ResponseEntity<>(response, HttpStatus.CREATED);
           }catch (AuthenticationException e) {
               Map<String, Object> map = new HashMap<>();
               map.put("message", "Authentication failed");
               map.put("status", false);
               return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);

           }
       }
}
