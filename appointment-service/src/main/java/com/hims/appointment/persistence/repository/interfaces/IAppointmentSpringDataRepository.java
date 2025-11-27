package com.hims.appointment.persistence.repository.interfaces;

import com.hims.appointment.persistence.dbo.AppointmentDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IAppointmentSpringDataRepository extends JpaRepository<AppointmentDbo, UUID> {

    List<AppointmentDbo> findByDoctorId(UUID id);

    List<AppointmentDbo> findByPatientId(UUID patientId);
}
