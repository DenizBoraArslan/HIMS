package com.hims.employee.application.mapper;

import com.hims.employee.application.dto.EmployeeDto;
import com.hims.employee.domain.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoMapper {

    public EmployeeDto toDto(Employee employee){

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getDepartment(),
                employee.getRole(),
                employee.getGender());

    }
    public Employee toEntity(EmployeeDto employeeDto){

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPhoneNumber(),
                employeeDto.getDepartment(),
                employeeDto.getRole(),
                employeeDto.getGender());

    }


}
