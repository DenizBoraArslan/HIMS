package com.hims.doctor.application.interfaces;

import com.hims.doctor.domain.entity.Doctor;

import java.util.List;
import java.util.UUID;

public interface IDoctorRepository {

    void saveDoctor(Doctor doctor);
    List<Doctor> findDoctorById(UUID id);
    List<Doctor> findAllDoctors();
    void deleteDoctorById(UUID id);

}
