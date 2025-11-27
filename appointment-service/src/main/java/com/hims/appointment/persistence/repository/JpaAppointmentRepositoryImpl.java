package com.hims.appointment.persistence.repository;

import com.hims.appointment.application.dto.AppointmentDto;
import com.hims.appointment.application.interfaces.IAppointmentRepository;
import com.hims.appointment.domain.entity.Appointment;
import com.hims.appointment.persistence.dbo.AppointmentDbo;
import com.hims.appointment.persistence.mapper.AppointmentMapper;
import com.hims.appointment.persistence.repository.interfaces.IAppointmentSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JpaAppointmentRepositoryImpl implements IAppointmentRepository {

    private final IAppointmentSpringDataRepository jpaRepository;
    private final AppointmentMapper mapper;

    @Override
    public void save(Appointment appointment) {

        AppointmentDbo dbo = mapper.toDbo(appointment);
        jpaRepository.save(dbo);
    }

    @Override
    public Optional<Appointment> findById(UUID id) {

        Optional<AppointmentDbo> dbo = jpaRepository.findById(id);
        return dbo.map(mapper::toDomain);
    }

    @Override
    public List<Appointment> findAll() {

        List<AppointmentDbo> dboList = jpaRepository.findAll();
        return dboList.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {

        jpaRepository.deleteById(id);
    }

    @Override
    public List<Appointment> findByDoctorId(UUID id) {

        List<AppointmentDbo> dboList = jpaRepository.findByDoctorId(id);
        return dboList.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Appointment> findByPatientId(UUID id) {

        List<AppointmentDbo> dboList = jpaRepository.findByPatientId(id);
        return dboList.stream().map(mapper::toDomain).collect(Collectors.toList());
    }


}
