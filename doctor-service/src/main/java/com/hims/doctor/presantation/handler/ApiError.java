package com.hims.doctor.presantation.handler;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {

    private Integer httpStatus;
    private T message;
    private LocalDateTime timestamp;
    private String path;
}
