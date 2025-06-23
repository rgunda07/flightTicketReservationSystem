package com.example.flightticketreservationsystem.controllers;

import com.example.flightticketreservationsystem.domains.Reservation;
import com.example.flightticketreservationsystem.dto.ReservationUpdateRequest;
import com.example.flightticketreservationsystem.exceptions.ReservationNotFound;
import com.example.flightticketreservationsystem.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationRestController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable String id) {
        Reservation reservation = reservationRepository.getReservationById(id);
        if (reservation == null) {
            throw new ReservationNotFound("No reservation exist with id " + id);
        }
        return reservation;
    }


    @PostMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest req) {
        Reservation r = reservationRepository.getReservationById(req.getId());
        if (r == null) {
            throw new ReservationNotFound("No reservation exist with id " + req.getId());
        }
        r.setNumberOfBags(req.getNumberOfBags());
        // r.setCheckedin(req.isCheckedIn());
        return reservationRepository.saveReservation(r);
    }

}
