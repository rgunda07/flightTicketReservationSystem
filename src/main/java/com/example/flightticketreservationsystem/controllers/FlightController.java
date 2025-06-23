package com.example.flightticketreservationsystem.controllers;

import com.example.flightticketreservationsystem.domains.Flight;
import com.example.flightticketreservationsystem.repositories.FlightRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FlightController {

    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/findFlights")
    public String showFindFlightsPage() {
        return "flights/findFlights";
    }

    @PostMapping("/findFlights")
    public String findFlights(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination,
            @RequestParam("departDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departDate,
            ModelMap modelMap) {

//        // This remains the same - the repository implementation handles the DynamoDB query
        List<Flight> flights = flightRepository.findFlights(
                source,
                destination,
                departDate
        );

//        modelMap.put("msg", "No Flights Available");
        modelMap.put("flights", flights);
        return "flights/displayFlights";
    }
}