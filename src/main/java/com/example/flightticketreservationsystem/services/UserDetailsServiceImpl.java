//package com.example.flightticketreservationsystem.services;
//
//import com.example.flightticketreservationsystem.domains.User;
//import com.example.flightticketreservationsystem.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userOptional = userRepository.findByEmail(username);
//        if (!userOptional.isPresent()) {
//            throw new UsernameNotFoundException("User not found for email " + username);
//        }
//        User user = userOptional.get();
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), user.getPassword(), user.getRoles()
//        );
//    }
//}
