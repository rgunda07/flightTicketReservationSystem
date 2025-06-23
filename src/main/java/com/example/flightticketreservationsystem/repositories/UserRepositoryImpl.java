package com.example.flightticketreservationsystem.repositories;

import com.example.flightticketreservationsystem.domains.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> usersById = new HashMap<>();
    private final Map<String, User> usersByEmail = new HashMap<>();

    @Override
    public void saveUser(User user) {
        usersById.put(user.getId(), user);
        usersByEmail.put(user.getEmail(), user);
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return Optional.ofNullable(usersById.get(userId));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(usersByEmail.get(email));
    }
}
