package com.example.flightticketreservationsystem.repositories;

import com.example.flightticketreservationsystem.domains.Reservation;

import java.util.List;

public interface ReservationRepository {
    Reservation saveReservation(Reservation reservation);
    Reservation getReservationById(String reservationId);
    List<Reservation> getReservationsByPassengerEmail(String userEmail);

    void deleteReservation(String reservationId);
}
