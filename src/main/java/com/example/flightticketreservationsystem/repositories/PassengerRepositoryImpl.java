package com.example.flightticketreservationsystem.repositories;

import com.example.flightticketreservationsystem.domains.Passenger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PassengerRepositoryImpl implements PassengerRepository {

    private List<Passenger> passengers = new ArrayList<>();

    @Override
    public void savePassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    @Override
    public Passenger getPassengerById(String passengerId) {
        return passengers.stream()
                .filter(p -> p.getId().equals(passengerId))
                .findFirst()
                .orElse(null);
    }
}
