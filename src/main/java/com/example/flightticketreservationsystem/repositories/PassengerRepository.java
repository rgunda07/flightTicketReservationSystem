package com.example.flightticketreservationsystem.repositories;

import com.example.flightticketreservationsystem.domains.Passenger;

public interface PassengerRepository {
    void savePassenger(Passenger passenger);
    Passenger getPassengerById(String passengerId);
}
