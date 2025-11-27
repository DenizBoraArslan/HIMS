package com.hims.patient.appilcation.interfaces;

import com.hims.patient.domain.entites.Patient;

import java.util.List;
import java.util.UUID;

public interface IPatientRepository {

    void savePatient(Patient patient);
    List<Patient> getAllPatients();
    List<Patient> getPatientById(UUID patientId);
    void deletePatient(UUID patientId);

}
