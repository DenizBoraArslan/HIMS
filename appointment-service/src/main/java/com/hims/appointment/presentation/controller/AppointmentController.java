package com.hims.appointment.presentation.controller;

import com.hims.appointment.application.dto.AppointmentDto;
import com.hims.appointment.application.usecases.AppointmentUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.hims.appointment.presentation.config.ApiPaths.*;

@RestController
@RequestMapping(API_BASE)
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentUseCase appointmentUseCase;

    // Save Appointment
    @PostMapping(SAVE_APPOINTMENT)
    public ResponseEntity<Void> save(@Valid @RequestBody AppointmentDto appointmentDto) {

        appointmentUseCase.save(appointmentDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Get All Appointments
    @GetMapping(GET_ALL_APPOINTMENTS)
    public ResponseEntity<List<AppointmentDto>> findAll() {
        List<AppointmentDto> appointmentDtoList = appointmentUseCase.findAll();
        return ResponseEntity.ok(appointmentDtoList);
    }

    // Get Appointments by Doctor ID
    @GetMapping(GET_BY_DOCTOR_ID + "/{id}")
    public ResponseEntity<List<AppointmentDto>> findByDoctorId(@Valid @PathVariable("id") UUID id) {

        List<AppointmentDto> dtoList = appointmentUseCase.findByDoctorId(id);
        return ResponseEntity.ok(dtoList);

    }

    // Get Appointments by Patient ID
    @GetMapping(GET_BY_PATIENT_ID + "/{id}")
    public ResponseEntity<List<AppointmentDto>> findByPatientId(@Valid @PathVariable("id") UUID id) {

        List<AppointmentDto> dtoList = appointmentUseCase.findByPatientId(id);
        return ResponseEntity.ok(dtoList);

    }

    // Delete Appointment by ID
    @DeleteMapping(DELETE_APPOINTMENT + "/{id}")
    public ResponseEntity<Void> deleteAppointment(@Valid @PathVariable("id") UUID id) {
        appointmentUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Update Appointment
    @PutMapping(UPDATE_APPOINTMENT)
    public ResponseEntity<Void> updateAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
        appointmentUseCase.updateAppointment(appointmentDto);
        return ResponseEntity.ok().build();
    }

}


