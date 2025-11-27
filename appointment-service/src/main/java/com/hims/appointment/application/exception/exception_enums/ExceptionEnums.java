package com.hims.appointment.application.exception.exception_enums;

import lombok.Getter;

@Getter
public enum ExceptionEnums {


    INVALID_APPOINTMENT_DATE("", "Invalid appointment date"),
    DOCTOR_ID_CANNOT_BE_NULL("", "Doctor ID cannot be null"),
    PATIENT_ID_CANNOT_BE_NULL("", "Patient ID cannot be null"),
    APPOINTMENT_ALREADY_EXISTS("", "Appointment already exists"),
    APPOINTMENT_NOT_FOUND("", "Appointment not found"),
    NO_APPOINTMENTS_FOUND("", "No appointments found"),
    ID_CANNOT_BE_CHANGED("", "Id cannot be changed");

    private String code;
    private String messageType;

    ExceptionEnums(String code, String messageType) {
        this.code = code;
        this.messageType = messageType;
    }

}
