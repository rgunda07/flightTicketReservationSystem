package com.example.flightticketreservationsystem.repositories;

import com.example.flightticketreservationsystem.domains.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository {

    void saveFlight(Flight flight);

    Flight getFlightById(String flightId);

    List<Flight> findFlights(String source, String destination, LocalDate date);
}
