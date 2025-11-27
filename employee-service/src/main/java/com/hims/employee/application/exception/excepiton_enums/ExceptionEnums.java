package com.hims.employee.application.exception.excepiton_enums;

import lombok.Getter;

@Getter
public enum ExceptionEnums {

    EMPLOYEE_NOT_FOUND("", "Employee not found."),
    ID_CANNOT_BE_NULL("","Id cannot be null" );

    private String code;
    private String messageType;

    ExceptionEnums(String code, String message) {
        this.code = code;
        this.messageType = message;
    }
}
