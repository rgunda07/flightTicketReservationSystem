//
//package com.example.flightticketreservationsystem.controllers;
//
//import com.amazonaws.AmazonServiceException;
//import com.example.flightticketreservationsystem.domains.Reservation;
//import com.example.flightticketreservationsystem.services.ReservationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("myBookings")
//public class MyBookingsController {
//
//    private final ReservationService reservationService;
//
//    @Autowired
//    public MyBookingsController(ReservationService reservationService) {
//        this.reservationService = reservationService;
//    }
//
//    @GetMapping("/myBookings")
//    public String showMyBookings(Authentication authentication, Model model) {
//        System.out.println("Logged in user: ");
//        try {
//            String email = authentication.getName();
//            List<Reservation> bookings = reservationService.getMyBookings(email);
//            model.addAttribute("bookings", bookings);
//            return "reservation/myBookings";
//        } catch (AmazonServiceException ex) {
//            model.addAttribute("error", "Failed to retrieve bookings. Please try again later.");
//            return "error";
//        }
//    }
//}
