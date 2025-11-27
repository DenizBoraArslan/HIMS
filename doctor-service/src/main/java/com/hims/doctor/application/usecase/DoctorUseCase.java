package com.hims.doctor.application.usecase;

import com.hims.doctor.application.dto.DoctorDto;
import com.hims.doctor.application.exception.BaseException;
import com.hims.doctor.application.exception.ErrorMessage;
import com.hims.doctor.application.exception.exception_enums.ExceptionEnums;
import com.hims.doctor.application.interfaces.IDoctorRepository;
import com.hims.doctor.application.mapper.DtoMapper;
import com.hims.doctor.domain.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorUseCase {

    private final IDoctorRepository doctorRepository;
    private final DtoMapper dtoMapper;

    public void save(DoctorDto doctorDto) {

        Doctor doctor = new Doctor(

                UUID.randomUUID(),
                doctorDto.getFirstName(),
                doctorDto.getLastName(),
                doctorDto.getGender(),
                doctorDto.getSpecialization(),
                true,
                doctorDto.getDepartmentId(),
                doctorDto.getTitle(),
                doctorDto.getEmail(),
                doctorDto.getPhoneNumber()

        );
        doctorRepository.saveDoctor(doctor);
    }

    public void deleteDoctorById(UUID id) {

        if (doctorRepository.findDoctorById(id).isEmpty()) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.DOCTOR_NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        doctorRepository.deleteDoctorById(id);
    }

    public void updateDoctor(DoctorDto doctorDto) {

        Doctor doctor = dtoMapper.toEntity(doctorDto);

        if (doctorRepository.findDoctorById(doctor.getId()).isEmpty()) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.DOCTOR_NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        doctorRepository.saveDoctor(doctor);
    }

    public List<DoctorDto> getDoctorById(UUID id) {

        return doctorRepository.findDoctorById(id).stream().map(dtoMapper::toDto).toList();
    }

    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAllDoctors().stream().map(dtoMapper::toDto).toList();
    }
}
