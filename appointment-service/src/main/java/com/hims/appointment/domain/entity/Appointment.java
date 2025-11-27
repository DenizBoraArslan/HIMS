package com.hims.appointment.domain.entity;


import com.hims.appointment.domain.enums.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {

    private UUID id;
    private LocalDateTime dateTime;
    private AppointmentStatus appointmentStatus;
    private UUID patientId;
    private UUID doctorId;
    private String notes;

    public Appointment() {
    }

    public Appointment(UUID id, LocalDateTime dateTime, AppointmentStatus appointmentStatus, UUID doctorId, UUID patientId, String notes) {
        this.id = id;
        this.dateTime = dateTime;
        this.appointmentStatus = appointmentStatus;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.notes = notes;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
