package com.hims.appointment.application.dto;

import com.hims.appointment.domain.enums.AppointmentStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private UUID id;

    @NotNull(message = "Date and Time cannot be null")
    @Future(message = "Appointment date and time must be in the future")
    private LocalDateTime dateTime;
    private AppointmentStatus appointmentStatus;

    @NotNull(message = "Patient ID cannot be null")
    private UUID patientId;

    @NotNull(message = "Doctor ID cannot be null")
    private UUID doctorId;
    private String notes;



}
