package com.example.flightticketreservationsystem.services;

import com.example.flightticketreservationsystem.domains.Reservation;
import com.example.flightticketreservationsystem.dto.ReservationRequest;

import java.util.List;

public interface ReservationService {
    Reservation bookFlight(ReservationRequest reservationRequest);
    List<Reservation> getMyBookings(String passengerEmail);
    Reservation updateNumberOfBags(String reservationId, int numberOfBags);
    Reservation getReservationById(String reservationId);
    void deleteReservation(String reservationId);
}
