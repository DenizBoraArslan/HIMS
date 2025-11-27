package com.hims.doctor.domain.entity;

import com.hims.doctor.domain.enums.Gender;
import com.hims.doctor.domain.enums.Specialization;
import com.hims.doctor.domain.enums.Title;

import java.util.UUID;

public class Doctor {

    private UUID id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Specialization specialization;
    private boolean isActive;


    private UUID departmentId;
    private Title title;
    private String email;
    private String phoneNumber;

    public Doctor() {

    }

    public Doctor(UUID id, String firstName, String lastName, Gender gender, Specialization specialization, boolean isActive, UUID departmentId, Title title, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.specialization = specialization;
        this.isActive = isActive;
        this.departmentId = departmentId;
        this.title = title;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void updateContactInfo(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void assignToDepartment(UUID departmentId) {

        if (departmentId == null) {
            throw new IllegalArgumentException("Department ID cannot be null");
        }

        this.departmentId = departmentId;
    }

    public void promote(Title title) {
        this.title = title;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;

    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public boolean isActive() {
        return isActive;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    public Title getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
