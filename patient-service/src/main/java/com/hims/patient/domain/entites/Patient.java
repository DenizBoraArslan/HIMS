package com.hims.patient.domain.entites;

import com.hims.patient.domain.enums.Gender;
import com.hims.patient.domain.enums.InsuranceType;

import java.time.LocalDate;
import java.util.UUID;

public class Patient {

    private UUID id;
    private Long nationalIdNumber;
    private String name;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String Address;
    private LocalDate dateOfBirth;
    private InsuranceType insuranceType;
    private Gender gender;

    public Patient() {

    }

    public Patient(UUID id, Long nationalIdNumber, String name, String lastname, String email, String phoneNumber, String address, LocalDate dateOfBirth, InsuranceType insuranceType, Gender gender) {
        this.id = id;
        this.nationalIdNumber = nationalIdNumber;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.dateOfBirth = dateOfBirth;
        this.insuranceType = insuranceType;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public Long getNationalIdNumber() {
        return nationalIdNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNationalIdNumber(Long nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
