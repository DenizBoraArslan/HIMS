package com.hims.appointment.application.interfaces;

import com.hims.appointment.application.dto.AppointmentDto;
import com.hims.appointment.domain.entity.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface IAppointmentRepository {

    void save(Appointment appointment);
    Optional<Appointment> findById(UUID id);
    List<Appointment> findAll();
    void deleteById(UUID id);
    List<Appointment> findByDoctorId(UUID id);
    List<Appointment> findByPatientId(UUID id);
}
