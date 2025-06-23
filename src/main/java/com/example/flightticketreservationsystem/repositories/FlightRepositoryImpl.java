package com.example.flightticketreservationsystem.repositories;

import com.example.flightticketreservationsystem.domains.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FlightRepositoryImpl implements FlightRepository {

    // In-memory store for demo
    private List<Flight> flights = new ArrayList<>();

    @Override
    public void saveFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public Flight getFlightById(String flightId) {
        Flight flight1 = new Flight();
        flight1.setFlightNumber("A123");
        flight1.setArrivalCity("ORD");
        flight1.setDepartureCity("JFK");
        flight1.setId(UUID.randomUUID().toString());
        flight1.setDateOfDeparture(LocalDate.of(2025,07,20));
        flight1.setEstimatedDepartureTime(LocalDateTime.of(2025,06,24,10,30));
        flight1.setOperatingAirlines("UCMA");
        return flight1;
    }

    @Override
    public List<Flight> findFlights(String source, String destination, LocalDate date) {
        Flight flight = new Flight();
        flight.setFlightNumber("A123");
        flight.setArrivalCity("ORD");
        flight.setDepartureCity("JFK");
        flight.setId(UUID.randomUUID().toString());
        flight.setDateOfDeparture(LocalDate.of(2025, 6,24));
        flight.setEstimatedDepartureTime(LocalDateTime.of(2025,06,24,12,15));
        flight.setOperatingAirlines("UCMA");
        Flight flight2 = new Flight();
        flight2.setFlightNumber("A124");
        flight2.setArrivalCity("ORD");
        flight2.setDepartureCity("JFK");
        flight2.setId(UUID.randomUUID().toString());
        flight2.setDateOfDeparture(LocalDate.of(2025,06,24));
        flight2.setEstimatedDepartureTime(LocalDateTime.of(2025,06,24,14,40));
        flight2.setOperatingAirlines("UCMA");
        Flight flight3 = new Flight();
        flight3.setFlightNumber("A125");
        flight3.setArrivalCity("ORD");
        flight3.setDepartureCity("JFK");
        flight3.setId(UUID.randomUUID().toString());
        flight3.setDateOfDeparture(LocalDate.of(2025,06,24));
        flight3.setEstimatedDepartureTime(LocalDateTime.of(2025,06,24,16,35));
        flight3.setOperatingAirlines("UCMA");
        Flight flight4 = new Flight();
        flight4.setFlightNumber("A126");
        flight4.setArrivalCity("ORD");
        flight4.setDepartureCity("JFK");
        flight4.setId(UUID.randomUUID().toString());
        flight4.setDateOfDeparture(LocalDate.of(2025,06,24));
        flight4.setEstimatedDepartureTime(LocalDateTime.of(2025,06,24,21,30));
        flight4.setOperatingAirlines("UCMA");
        List<Flight> flight1 = new ArrayList<>();
        flight1.add(flight);
        flight1.add(flight2);
        flight1.add(flight3);
        flight1.add(flight4);

        return flight1;
    }

//    @Override
//    public List<Flight> findFlights(String source, String destination, LocalDate date) {
//        // Your filtering logic here
//        return flights.stream()
//                .filter(f -> f.getSource().equals(source) && f.getDestination().equals(destination) && f.getDate().equals(date))
//                .toList();
//    }
}

