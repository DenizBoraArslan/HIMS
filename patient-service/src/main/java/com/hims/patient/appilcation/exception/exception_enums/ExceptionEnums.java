package com.hims.patient.appilcation.exception.exception_enums;

import lombok.Getter;

@Getter
public enum ExceptionEnums {

    PATIENT_ID_CANNOT_BE_NULL,
    PATIENT_NOT_FOUND,
    ID_CANNOT_BE_CHANGED;

    private String code;
    private String messageType;
}
