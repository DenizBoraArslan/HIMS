package com.hims.doctor.persistence.repository.interfaces;

import com.hims.doctor.persistence.dbo.DoctorDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDoctorSpringDataRepository extends JpaRepository<DoctorDbo, UUID> {
    Optional<DoctorDbo> findById(UUID id);
}
