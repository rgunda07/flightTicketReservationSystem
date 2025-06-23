package com.example.flightticketreservationsystem.controllers;

import com.example.flightticketreservationsystem.domains.Flight;
import com.example.flightticketreservationsystem.domains.Reservation;
import com.example.flightticketreservationsystem.dto.ReservationRequest;
import com.example.flightticketreservationsystem.exceptions.FlightNotFound;
import com.example.flightticketreservationsystem.repositories.FlightRepository;
import com.example.flightticketreservationsystem.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final FlightRepository flightRepository;
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(FlightRepository flightRepository,
                                 ReservationService reservationService) {
        this.flightRepository = flightRepository;
        this.reservationService = reservationService;
    }

    @GetMapping("/complete")
    public String showCompleteReservation(@RequestParam("flightId") String flightId,
                                          Model model) {

        Flight flight = flightRepository.getFlightById(flightId);
        if (flight == null) {
            throw new FlightNotFound("Flight not found: " + flightId);
        }

        ReservationRequest req = new ReservationRequest();
        req.setFlightId(flightId);

        model.addAttribute("flight", flight);
        model.addAttribute("reservationRequest", req);
        return "reservation/completeReservation";
    }


    @PostMapping("/complete")
    public String completeReservation(@ModelAttribute("reservationRequest") ReservationRequest req,
                                      Model model) {
        Reservation r = reservationService.bookFlight(req);
        model.addAttribute("msg",
                "Reservation created successfully — your reservation ID is " + r.getId());
        return "reservation/reservationConfirmation";
    }

    @GetMapping("/completeReservation")
    public String completeReservationRedirect() {
        return "redirect:/findFlights";
    }

    @GetMapping("/myBookings")
    public String myBookings(Principal principal, Model model) {
        System.out.println("Principal: " + principal);
        if (principal == null) {
            return "reservation/myBookings";
        }
        String email = principal.getName();
        model.addAttribute("bookings", reservationService.getMyBookings(email));
        return "reservation/myBookings";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id,
                               ModelMap model) {
        Reservation res = reservationService.getReservationById(id);
        model.addAttribute("reservation", res);
        return "reservation/editReservation";
    }

    @PostMapping("/{id}/edit")
    public String updateReservation(@PathVariable String id,
                                    @RequestParam("numberOfBags") int numberOfBags) {
        reservationService.updateNumberOfBags(id, numberOfBags);
        return "redirect:/reservations/myBookings";
    }

    @PostMapping("/{id}/delete")
    public String deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations/myBookings";
    }
}
