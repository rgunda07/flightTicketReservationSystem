package com.example.flightticketreservationsystem.services;

import com.example.flightticketreservationsystem.domains.Flight;
import com.example.flightticketreservationsystem.domains.Passenger;
import com.example.flightticketreservationsystem.domains.Reservation;
import com.example.flightticketreservationsystem.dto.ReservationRequest;
import com.example.flightticketreservationsystem.exceptions.FlightNotFound;
import com.example.flightticketreservationsystem.repositories.FlightRepository;
import com.example.flightticketreservationsystem.repositories.PassengerRepository;
import com.example.flightticketreservationsystem.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest req) {
        Flight flight = flightRepository.getFlightById(req.getFlightId());
        if (flight == null) {
            throw new FlightNotFound("No flight with id " + req.getFlightId());
        }

        Passenger passenger = new Passenger();
//        String passengerId = UUID.randomUUID().toString();
//        passenger.setPassengerId(passengerId);
        passenger.setFirstName(req.getPassengerFirstName());
        passenger.setMiddleName(req.getPassengerMiddleName());
        passenger.setLastName(req.getPassengerLastName());
        passenger.setEmail(req.getPassengerEmail());
        passenger.setPhone(req.getPassengerPhoneNumber());
        passengerRepository.savePassenger(passenger);

        Reservation reservation = new Reservation();
        reservation.setId(UUID.randomUUID().toString());
//        reservation.setFlight(flight.getFlightId());
//        reservation.s(passenger.getEmail());
//        reservation.setCheckedin(false);
        reservation.setNumberOfBags(0);

        reservationRepository.saveReservation(reservation);

        return reservation;
    }

    @Override
    public List<Reservation> getMyBookings(String passengerEmail) {
        Reservation reservation = new Reservation();
        Passenger passenger = new Passenger();
        passenger.setFirstName("Rahul");
        passenger.setLastName("Gunda");
        passenger.setEmail(passengerEmail);
        passenger.setPhone("12345");
        Flight flight1 = new Flight();
        flight1.setFlightNumber("A123");
        flight1.setArrivalCity("ORD");
        flight1.setDepartureCity("JFK");
        flight1.setId(UUID.randomUUID().toString());
        flight1.setDateOfDeparture(LocalDate.of(2025,07,20));
        flight1.setEstimatedDepartureTime(LocalDateTime.of(2025,06,24,10,30));
        flight1.setOperatingAirlines("UCMA");
        reservation.setPassenger(passenger);
        reservation.setFlight(flight1);
        reservation.setNumberOfBags(2);
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(reservation);
        return reservationList;
    }

    @Override
    public Reservation updateNumberOfBags(String reservationId, int numberOfBags) {
        Reservation res = reservationRepository.getReservationById(reservationId);
        if (res == null) {
            throw new NoSuchElementException("Reservation not found: " + reservationId);
        }

        res.setNumberOfBags(numberOfBags);
        reservationRepository.saveReservation(res);

        return res;
    }

    @Override
    public Reservation getReservationById(String reservationId) {
        Reservation reservation = reservationRepository.getReservationById(reservationId);
        if (reservation == null) {
            throw new NoSuchElementException("Reservation not found: " + reservationId);
        }
        return reservation;
    }

    @Override
    public void deleteReservation(String reservationId) {
        // Optional: check if reservation exists before deleting
        Reservation reservation = reservationRepository.getReservationById(reservationId);
        if (reservation != null) {
            reservationRepository.deleteReservation(reservationId);
        } else {
            throw new NoSuchElementException("Reservation not found: " + reservationId);
        }
    }
}
