package com.hims.patient.persistence.repository;

import com.hims.patient.appilcation.interfaces.IPatientRepository;
import com.hims.patient.domain.entites.Patient;
import com.hims.patient.persistence.mapper.DboMapper;
import com.hims.patient.persistence.repository.interfaces.IPatientSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaPatientRepositoryImpl implements IPatientRepository {

    private final IPatientSpringDataRepository patientSpringDataRepository;

    @Override
    public void savePatient(Patient patient) {

        patientSpringDataRepository.save(DboMapper.toDbo(patient));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientSpringDataRepository.findAll().stream().map(DboMapper::toEntity).toList();
    }

    @Override
    public List<Patient> getPatientById(UUID patientId) {
        return patientSpringDataRepository.findById(patientId).stream().map(DboMapper::toEntity).toList();
    }

    @Override
    public void deletePatient(UUID patientId) {
        patientSpringDataRepository.deleteById(patientId);
    }
}
