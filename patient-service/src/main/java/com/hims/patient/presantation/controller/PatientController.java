package com.hims.patient.presantation.controller;

import com.hims.patient.appilcation.dto.PatientDto;
import com.hims.patient.appilcation.usecase.PatientUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.hims.patient.presantation.config.ApiPaths.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_BASE)
public class PatientController {

    private final PatientUseCase patientUseCase;

    @PostMapping(SAVE_PATIENT)
    public void save(@Valid @RequestBody PatientDto patientDto) {
        patientUseCase.save(patientDto);
        ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(GET_ALL_PATIENTS)
    public ResponseEntity<List<PatientDto>> findAll() {
        return ResponseEntity.ok(patientUseCase.findAll());
    }

    @GetMapping(GET_BY_PATIENT_ID + "/{id}")
    public ResponseEntity<List<PatientDto>> findByPatientId(@Valid @PathVariable UUID id) {
        return ResponseEntity.ok(patientUseCase.findByPatientId(id));
    }

    @DeleteMapping(DELETE_PATIENT + "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {

        patientUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<Object> update(PatientDto patientDto) {
        patientUseCase.update(patientDto);
        return ResponseEntity.ok().build();
    }

}
