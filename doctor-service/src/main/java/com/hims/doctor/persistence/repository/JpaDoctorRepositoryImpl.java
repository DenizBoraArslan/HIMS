package com.hims.doctor.persistence.repository;

import com.hims.doctor.application.interfaces.IDoctorRepository;
import com.hims.doctor.domain.entity.Doctor;
import com.hims.doctor.persistence.dbo.DoctorDbo;
import com.hims.doctor.persistence.mapper.DoctorDboMapper;
import com.hims.doctor.persistence.repository.interfaces.IDoctorSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaDoctorRepositoryImpl implements IDoctorRepository {

    private final IDoctorSpringDataRepository doctorSpringDataRepository;
    private final DoctorDboMapper doctorDboMapper;


    @Override
    public void saveDoctor(Doctor doctor) {

        doctorSpringDataRepository.save(doctorDboMapper.toDbo(doctor));
    }

    @Override
    public List<Doctor> findDoctorById(UUID id) {

        return doctorSpringDataRepository.findById(id).stream().map(doctorDboMapper::toDomain).toList();
    }

    @Override
    public List<Doctor> findAllDoctors() {

        return doctorSpringDataRepository.findAll().stream().map(doctorDboMapper::toDomain).toList();
    }

    @Override
    public void deleteDoctorById(UUID id) {

        doctorSpringDataRepository.deleteById(id);
    }
}
