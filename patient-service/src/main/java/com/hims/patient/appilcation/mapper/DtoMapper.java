package com.hims.patient.appilcation.mapper;

import com.hims.patient.appilcation.dto.PatientDto;
import com.hims.patient.domain.entites.Patient;

public class DtoMapper {

    public static PatientDto toDto(Patient patient) {
        return new PatientDto(
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

    public static Patient toEntity(PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getNationalIdNumber(),
                patientDto.getName(),
                patientDto.getLastname(),
                patientDto.getEmail(),
                patientDto.getPhoneNumber(),
                patientDto.getAddress(),
                patientDto.getDateOfBirth(),
                patientDto.getInsuranceType(),
                patientDto.getGender()

        );
    }

}
