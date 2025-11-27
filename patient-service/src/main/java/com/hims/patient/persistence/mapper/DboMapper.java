package com.hims.patient.persistence.mapper;

import com.hims.patient.domain.entites.Patient;
import com.hims.patient.persistence.dbo.PatientDbo;

public class DboMapper {

    public static Patient toEntity(PatientDbo patientDbo) {
        return new Patient(

                patientDbo.getId(),
                patientDbo.getNationalIdNumber(),
                patientDbo.getName(),
                patientDbo.getLastname(),
                patientDbo.getEmail(),
                patientDbo.getPhoneNumber(),
                patientDbo.getAddress(),
                patientDbo.getDateOfBirth(),
                patientDbo.getInsuranceType(),
                patientDbo.getGender()


        );
    }

    public static PatientDbo toDbo(Patient patient) {
        return new PatientDbo(

                patient.getId(),
                patient.getNationalIdNumber(),
                patient.getName(),
                patient.getLastname(),
                patient.getEmail(),
                patient.getPhoneNumber(),
                patient.getAddress(),
                patient.getDateOfBirth(),
                patient.getInsuranceType(),
                patient.getGender()


        );
    }


}
