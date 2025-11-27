package com.hims.appointment.application.mapper;

import com.hims.appointment.application.dto.AppointmentDto;
import com.hims.appointment.domain.entity.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoMapper {

    public Appointment toEntity(AppointmentDto appointmentDto) {

        return new Appointment(
                appointmentDto.getId(),
                appointmentDto.getDateTime(),
                appointmentDto.getAppointmentStatus(),
                appointmentDto.getDoctorId(),
                appointmentDto.getPatientId(),
                appointmentDto.getNotes()
        );
    }

    public AppointmentDto toDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getDateTime(),
                appointment.getAppointmentStatus(),
                appointment.getPatientId(),
                appointment.getDoctorId(),
                appointment.getNotes()
        );
    }

    public List<AppointmentDto> toDtoList(List<Appointment> appointmentList) {
        return appointmentList.stream()
                .map(this::toDto)
                .toList();
    }
}

