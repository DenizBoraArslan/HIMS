package com.hims.patient.appilcation.usecase;

import com.hims.patient.appilcation.dto.PatientDto;
import com.hims.patient.appilcation.exception.BaseException;
import com.hims.patient.appilcation.exception.ErrorMessage;
import com.hims.patient.appilcation.exception.exception_enums.ExceptionEnums;
import com.hims.patient.appilcation.interfaces.IPatientRepository;
import com.hims.patient.appilcation.mapper.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientUseCase {

    private final IPatientRepository patientRepository;

    public void save(PatientDto patientDto) {

        if (patientRepository.getPatientById(patientDto.getId()) == null) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.PATIENT_ID_CANNOT_BE_NULL));
        }
        patientRepository.savePatient(DtoMapper.toEntity(patientDto));
    }

    public List<PatientDto> findAll() {

        return patientRepository.getAllPatients().stream().map(DtoMapper::toDto).toList();
    }

    public List<PatientDto> findByPatientId(UUID patientId) {

        if (patientRepository.getPatientById(patientId) == null) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.PATIENT_ID_CANNOT_BE_NULL));
        } else if (patientRepository.getPatientById(patientId).isEmpty()) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.PATIENT_NOT_FOUND));
        }

        return patientRepository.getPatientById(patientId).stream().map(DtoMapper::toDto).toList();
    }

    public void delete(UUID patientId) {

        if (patientRepository.getPatientById(patientId) == null) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.PATIENT_ID_CANNOT_BE_NULL));
        } else if (patientRepository.getPatientById(patientId).isEmpty()) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.PATIENT_NOT_FOUND));
        }


        patientRepository.deletePatient(patientId);
    }

    public void update(PatientDto patientDto) {
        if (patientRepository.getPatientById(patientDto.getId()) == null) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.PATIENT_ID_CANNOT_BE_NULL));
        }
        if(patientRepository.getPatientById(patientDto.getId()).equals(patientDto.getId())) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.ID_CANNOT_BE_CHANGED));
        }
        patientRepository.savePatient(DtoMapper.toEntity(patientDto));
    }
}
