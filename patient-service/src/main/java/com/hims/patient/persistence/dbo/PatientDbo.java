package com.hims.patient.persistence.dbo;

import com.hims.patient.domain.enums.Gender;
import com.hims.patient.domain.enums.InsuranceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class PatientDbo {

    @Id
    private UUID id;

    @Column(name = "national_id_number")
    private Long nationalIdNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String Address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "insurance_type")
    private InsuranceType insuranceType;

    @Column(name = "gender")
    private Gender gender;


}
