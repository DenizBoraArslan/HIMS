package com.hims.doctor.application.mapper;

import com.hims.doctor.application.dto.DoctorDto;
import com.hims.doctor.domain.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    public Doctor toEntity(DoctorDto doctorDto) {

        return new Doctor(

                doctorDto.getId(),
                doctorDto.getFirstName(),
                doctorDto.getLastName(),
                doctorDto.getGender(),
                doctorDto.getSpecialization(),
                doctorDto.isActive(),
                doctorDto.getDepartmentId(),
                doctorDto.getTitle(),
                doctorDto.getEmail(),
                doctorDto.getPhoneNumber()

        );
    }

    public DoctorDto toDto(Doctor doctor) {

        return new DoctorDto(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getGender(),
                doctor.getSpecialization(),
                doctor.isActive(),
                doctor.getDepartmentId(),
                doctor.getTitle(),
                doctor.getEmail(),
                doctor.getPhoneNumber()
        );
    }


}
