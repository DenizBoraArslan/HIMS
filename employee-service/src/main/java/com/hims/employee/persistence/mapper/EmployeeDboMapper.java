package com.hims.employee.persistence.mapper;

import com.hims.employee.domain.entity.Employee;
import com.hims.employee.persistence.dbo.EmployeeDbo;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDboMapper {

    public EmployeeDbo toDbo(Employee employee) {

        return new EmployeeDbo(

                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getDepartment(),
                employee.getRole(),
                employee.getGender()

        );

    }

    public Employee toEntity(EmployeeDbo employeeDbo) {

        return new Employee(

                employeeDbo.getId(),
                employeeDbo.getFirstName(),
                employeeDbo.getLastName(),
                employeeDbo.getEmail(),
                employeeDbo.getPhoneNumber(),
                employeeDbo.getDepartment(),
                employeeDbo.getRole(),
                employeeDbo.getGender()

        );

    }

}
