package com.hims.doctor.application.exception.exception_enums;

import lombok.Getter;

@Getter
public enum ExceptionEnums {

    DOCTOR_NOT_FOUND("", ""),
    INVALID_DOCTOR_DATA("", " "),
    DOCTOR_ALREADY_EXISTS("", "Doctor is already exists.");

    private String code;
    private String messageType;

    ExceptionEnums(String code, String messageType) {
        this.code = code;
        this.messageType = messageType;
    }

}
