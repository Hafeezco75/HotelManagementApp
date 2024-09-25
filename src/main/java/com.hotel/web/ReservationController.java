package web;

import data.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.ReservationService;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


//    @PostMapping("/")
//    public String addReservation(@RequestBody Reservation reservation) {
//
//    }
//

}
