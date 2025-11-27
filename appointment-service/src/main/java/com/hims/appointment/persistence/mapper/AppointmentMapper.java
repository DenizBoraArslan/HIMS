package com.hims.appointment.persistence.mapper;

import com.hims.appointment.domain.entity.Appointment;
import com.hims.appointment.persistence.dbo.AppointmentDbo;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    // Convert DBO to Domain
    public Appointment toDomain(AppointmentDbo appointmentDbo) {

        if(appointmentDbo == null){
            return null;
        }
        Appointment appointment =new Appointment();

        appointment.setId(appointmentDbo.getId());
        appointment.setAppointmentStatus(appointmentDbo.getAppointmentStatus());
        appointment.setDateTime(appointmentDbo.getDateTime());
        appointment.setDoctorId(appointmentDbo.getDoctorId());
        appointment.setPatientId(appointmentDbo.getPatientId());
        appointment.setNotes(appointmentDbo.getNotes());

        return appointment;
    }

    // Convert Domain to DBO
    public AppointmentDbo toDbo(Appointment appointment) {

        AppointmentDbo appointmentDbo = new AppointmentDbo();

        if(appointment == null){
            return  null;
        }

        appointmentDbo.setId(appointment.getId());
        appointmentDbo.setAppointmentStatus(appointment.getAppointmentStatus());
        appointmentDbo.setDateTime(appointment.getDateTime());
        appointmentDbo.setDoctorId(appointment.getDoctorId());
        appointmentDbo.setPatientId(appointment.getPatientId());
        appointmentDbo.setNotes(appointment.getNotes());

        return appointmentDbo;
    }


}
