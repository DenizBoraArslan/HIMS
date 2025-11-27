package com.hims.doctor.presantation.controller;

import com.hims.doctor.application.dto.DoctorDto;
import com.hims.doctor.application.usecase.DoctorUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.hims.doctor.presantation.config.ApiPaths.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_BASE)
public class DoctorController {

    private final DoctorUseCase doctorUseCase;

    @PostMapping(SAVE_DOCTOR)
    public ResponseEntity<Void> save(@Valid @RequestBody DoctorDto doctorDto) {

        doctorUseCase.save(doctorDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping(DELETE_DOCTOR + "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {

        doctorUseCase.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(UPDATE_DOCTOR)
    public ResponseEntity<Void> update(@Valid @RequestBody DoctorDto doctorDto) {

        doctorUseCase.updateDoctor(doctorDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(GET_DOCTOR_BY_ID)
    public ResponseEntity<List<DoctorDto>> getDoctorById(UUID id) {

        return ResponseEntity.ok(doctorUseCase.getDoctorById(id));

    }

    @GetMapping(GET_ALL_DOCTORS)
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {

        return ResponseEntity.ok(doctorUseCase.getAllDoctors());

    }
}
