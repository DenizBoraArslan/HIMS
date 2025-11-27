package com.hims.employee.application.usecase;

import com.hims.employee.application.dto.EmployeeDto;
import com.hims.employee.application.exception.BaseException;
import com.hims.employee.application.exception.ErrorMessage;
import com.hims.employee.application.exception.excepiton_enums.ExceptionEnums;
import com.hims.employee.application.interfaces.IEmployeeRepository;
import com.hims.employee.application.mapper.EmployeeDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeUseCase {

    private final IEmployeeRepository employeeRepository;
    private final EmployeeDtoMapper employeeDtoMapper;

    public void saveEmployee(EmployeeDto employeeDto) {

        if (employeeDto.getId() == null) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.ID_CANNOT_BE_NULL), HttpStatus.CONFLICT);
        }

        employeeRepository.saveEmployee(employeeDtoMapper.toEntity(employeeDto));
    }

    public List<EmployeeDto> findAllEmployees() {


        return employeeRepository.findAllEmployees().stream().map(employeeDtoMapper::toDto).toList();

    }
    public void updateEmployee(EmployeeDto employeeDto) {

        if (employeeRepository.findEmployeeById(employeeDto.getId()).isEmpty()) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.EMPLOYEE_NOT_FOUND));
        }
        employeeRepository.saveEmployee(employeeDtoMapper.toEntity(employeeDto));
    }

    public List<EmployeeDto> findEmployeeById(UUID id) {
        return employeeRepository.findEmployeeById(id).stream().map(employeeDtoMapper::toDto).toList();
    }

    public void deleteEmployee(UUID id) {

        if(employeeRepository.findEmployeeById(id).isEmpty()){
            throw new BaseException(new ErrorMessage(ExceptionEnums.EMPLOYEE_NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        employeeRepository.deleteEmployeeById(id);
    }

}
