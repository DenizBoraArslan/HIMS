package com.hims.patient.persistence.repository.interfaces;

import com.hims.patient.persistence.dbo.PatientDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPatientSpringDataRepository extends JpaRepository<PatientDbo, UUID> {
}
