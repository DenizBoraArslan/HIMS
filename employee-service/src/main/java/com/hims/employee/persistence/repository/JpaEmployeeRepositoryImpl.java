package com.hims.employee.persistence.repository;

import com.hims.employee.application.interfaces.IEmployeeRepository;
import com.hims.employee.domain.entity.Employee;
import com.hims.employee.persistence.dbo.EmployeeDbo;
import com.hims.employee.persistence.mapper.EmployeeDboMapper;
import com.hims.employee.persistence.repository.interfaces.IEmployeeSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaEmployeeRepositoryImpl implements IEmployeeRepository {

    private final IEmployeeSpringDataRepository employeeSpringDataRepository;
    private final EmployeeDboMapper employeeDboMapper;


    @Override
    public void saveEmployee(Employee employee) {

        employeeSpringDataRepository.save(employeeDboMapper.toDbo(employee));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeSpringDataRepository.findAll().stream().map(employeeDboMapper::toEntity).toList();
    }

    @Override
    public List<Employee> findEmployeeById(UUID id) {
        return employeeSpringDataRepository.findById(id).stream().map(employeeDboMapper::toEntity).toList();
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        employeeSpringDataRepository.deleteById(id);
    }
}
