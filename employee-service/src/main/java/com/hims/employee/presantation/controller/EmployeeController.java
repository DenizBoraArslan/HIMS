package com.hims.employee.presantation.controller;

import com.hims.employee.application.dto.EmployeeDto;
import com.hims.employee.application.usecase.EmployeeUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.hims.employee.presantation.config.ApiPaths.*;

@RestController
@RequestMapping(API_BASE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeUseCase employeeUseCase;

    @PostMapping(SAVE_EMPLOYEE)
    public ResponseEntity<Void> save(@Valid @RequestBody EmployeeDto employeeDto) {

        employeeUseCase.saveEmployee(employeeDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping(DELETE_EMPLOYEE + "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {

        employeeUseCase.deleteEmployee(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping(UPDATE_EMPLOYEE)
    public ResponseEntity<Void> update(@Valid @RequestBody EmployeeDto employeeDto) {

        employeeUseCase.updateEmployee(employeeDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping(GET_EMPLOYEE_BY_ID + "/{id}")
    public ResponseEntity<List<EmployeeDto>> findEmployeeById(@Valid @PathVariable UUID id) {

        return ResponseEntity.ok(employeeUseCase.findEmployeeById(id));
    }

    @GetMapping(GET_ALL_EMPLOYEES)
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(employeeUseCase.findAllEmployees()) ;
    }

}
