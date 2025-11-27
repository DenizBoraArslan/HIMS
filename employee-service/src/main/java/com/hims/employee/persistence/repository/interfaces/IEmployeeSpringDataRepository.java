package com.hims.employee.persistence.repository.interfaces;

import com.hims.employee.persistence.dbo.EmployeeDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IEmployeeSpringDataRepository extends JpaRepository<EmployeeDbo, UUID> {
}
