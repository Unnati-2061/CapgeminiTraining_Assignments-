package com.gal.bootcompanny.model;

import java.beans.Transient;

public class EmployeeTransportDTO {
    //    Dto : Data Transder Object
    private String firstName;
    private String lastName;
    private String email;

    private String phoneNumber;

    public EmployeeTransportDTO(
            Employee e
    ) {
        super();
        this.firstName = e.getFirstName();
        this.lastName = e.getLastName();
        this.email = e.getEmail();

        this.phoneNumber = e.getPhoneNumber();
    }

    @Override
    public String toString() {
        return "EmployeeTransportDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}