package com.example.flightticketreservationsystem.services;

import com.example.flightticketreservationsystem.domains.User;
import com.example.flightticketreservationsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SecurityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean login(String username, String password) {
        Optional<User> userOpt = userRepository.getUserByEmail(username);
        if (userOpt.isEmpty()) {
            return false;
        }
        User user = userOpt.get();
        // Check password hash match
        return passwordEncoder.matches(password, user.getPassword());
    }
}
