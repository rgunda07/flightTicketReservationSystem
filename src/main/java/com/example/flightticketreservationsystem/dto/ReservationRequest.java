package com.example.flightticketreservationsystem.dto;

public class ReservationRequest {
    private String flightId;

    private String passengerFirstName;
    private String passengerMiddleName;
    private String passengerLastName;
    private String passengerEmail;
    private String passengerPhoneNumber;

    private String nameOnCard;
    private String cardNumber;
    private String cardExpiration;
    private String secCode;

    // --- getters & setters for every field ---

    public String getFlightId() {
        return flightId;
    }
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }
    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerMiddleName() {
        return passengerMiddleName;
    }
    public void setPassengerMiddleName(String passengerMiddleName) {
        this.passengerMiddleName = passengerMiddleName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }
    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }
    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerPhoneNumber() {
        return passengerPhoneNumber;
    }
    public void setPassengerPhoneNumber(String passengerPhoneNumber) {
        this.passengerPhoneNumber = passengerPhoneNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }
    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public String getSecCode() {
        return secCode;
    }
    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }
}
