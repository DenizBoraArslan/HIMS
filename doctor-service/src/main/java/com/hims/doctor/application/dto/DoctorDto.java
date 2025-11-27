package com.hims.doctor.application.dto;

import com.hims.doctor.domain.enums.Specialization;
import com.hims.doctor.domain.enums.Gender;
import com.hims.doctor.domain.enums.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private UUID id;

    private String firstName;
    private String lastName;
    private Gender gender;
    private Specialization specialization;
    private boolean isActive;


    private UUID departmentId;
    private Title title;
    private String email;
    private String phoneNumber;

}
