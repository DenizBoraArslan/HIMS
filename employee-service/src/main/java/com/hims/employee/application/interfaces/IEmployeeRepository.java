package com.hims.employee.application.interfaces;

import com.hims.employee.domain.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository {

    void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    List<Employee> findEmployeeById(UUID id);
    void deleteEmployeeById(UUID id);

}
