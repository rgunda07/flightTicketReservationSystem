package com.example.flightticketreservationsystem.repositories;

import com.example.flightticketreservationsystem.domains.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private List<Reservation> reservations = new ArrayList<>();

    @Override
    public Reservation saveReservation(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public Reservation getReservationById(String reservationId) {
        return reservations.stream()
                .filter(r -> r.getId().equals(reservationId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reservation> getReservationsByPassengerEmail(String userEmail) {
        return reservations.stream()
                .filter(r -> r.getPassenger().getEmail().equals(userEmail))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReservation(String reservationId) {
        reservations.removeIf(r -> r.getId().equals(reservationId));
    }
}