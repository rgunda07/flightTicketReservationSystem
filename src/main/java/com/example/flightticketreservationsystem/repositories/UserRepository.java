package com.example.flightticketreservationsystem.repositories;

import com.example.flightticketreservationsystem.domains.User;

import java.util.Optional;

public interface UserRepository {
    void saveUser(User user);
    Optional<User> getUserById(String userId);
    Optional<User> getUserByEmail(String email);
}
