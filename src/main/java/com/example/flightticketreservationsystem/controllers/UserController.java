package com.example.flightticketreservationsystem.controllers;

import com.example.flightticketreservationsystem.domains.User;
import com.example.flightticketreservationsystem.exceptions.UserAlreadyRegistered;
import com.example.flightticketreservationsystem.exceptions.UserNotFound;
import com.example.flightticketreservationsystem.repositories.UserRepository;
import com.example.flightticketreservationsystem.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/showReg")
    public String showRegistrationPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "login/registerUser";
    }

    @PostMapping("/registerUser")
    public String register(@ModelAttribute("user") User user) {
        Optional<User> found = userRepository.getUserByEmail(user.getEmail());
        if (found.isPresent()) {
            throw new UserAlreadyRegistered("Email exists: " + user.getEmail());
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.saveUser(user);
        return "login/login";
    }

    @GetMapping("/showLogin")
    public String showLoginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            ModelMap model) {

        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }
        if (logout != null) {
            model.addAttribute("msg", "You have been logged out successfully");
        }
        return "login/login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            ModelMap modelMap) {

        User user = userRepository.getUserByEmail(email)
                .orElseThrow(() -> new UserNotFound("Email not found: " + email));

        if (securityService.login(email, password)) {
            modelMap.addAttribute("msg", "Successfully logged in");
            return "flights/findFlights";
        } else {
            modelMap.addAttribute("msg", "Invalid username or password");
            return "login/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/showLogin?logout";
    }
}