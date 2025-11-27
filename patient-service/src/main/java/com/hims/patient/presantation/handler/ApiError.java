package com.hims.patient.presantation.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError<T> {

    private Integer httpStatus;
    private T message;
    private LocalDateTime timestamp;
    private String path;

}
