package com.hei.prog2.model;

import java.time.LocalDate;
import java.util.Objects;

public class Client {

    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String address;
    private String email;
    private String phoneNumber;

    public Client(String lastName, String firstName, LocalDate dateOfBirth,
                   String address, String email, String phoneNumber) {
        this.lastName = Objects.requireNonNull(lastName, "Last name must not be null");
        this.firstName = Objects.requireNonNull(firstName, "First name must not be null");
        this.dateOfBirth = Objects.requireNonNull(dateOfBirth, "Date of birth must not be null");
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Client[firstName=%s, lastName=%s, dateOfBirth=%s, email=%s, phone=%s]",
                firstName, lastName, dateOfBirth, email, phoneNumber);
    }
}
