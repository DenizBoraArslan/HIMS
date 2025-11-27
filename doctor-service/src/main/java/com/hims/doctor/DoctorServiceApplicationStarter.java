package com.hims.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.hims.doctor.persistence.repository")
@EntityScan("com.hims.doctor.persistence.dbo")
public class DoctorServiceApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(DoctorServiceApplicationStarter.class, args);
    }

}
