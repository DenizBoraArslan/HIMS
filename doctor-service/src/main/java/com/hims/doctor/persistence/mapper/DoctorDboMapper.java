package com.hims.doctor.persistence.mapper;

import com.hims.doctor.domain.entity.Doctor;
import com.hims.doctor.persistence.dbo.DoctorDbo;
import org.springframework.stereotype.Component;

@Component
public class DoctorDboMapper {

    //Convert DBO to Domain
    public Doctor toDomain(DoctorDbo doctorDbo) {

        if (doctorDbo.getId() == null) {
            return null;
        }

        return new Doctor(
                doctorDbo.getId(),
                doctorDbo.getFirstName(),
                doctorDbo.getLastName(),
                doctorDbo.getGender(),
                doctorDbo.getSpecialization(),
                true,
                doctorDbo.getDepartmentId(),
                doctorDbo.getTitle(),
                doctorDbo.getEmail(),
                doctorDbo.getPhoneNumber()

        );
    }

    //Convert Domain to DBO
    public DoctorDbo toDbo(Doctor doctor) {

        if(doctor.getId() == null) {
            return null;
        }
        return new DoctorDbo(
                doctor.getId(),
                doctor.getDepartmentId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getGender(),
                doctor.getSpecialization(),
                true,
                doctor.getTitle(),
                doctor.getEmail(),
                doctor.getPhoneNumber()
        );
    }


}
