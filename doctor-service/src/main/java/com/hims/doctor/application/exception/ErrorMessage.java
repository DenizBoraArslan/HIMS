package com.hims.doctor.application.exception;

import com.hims.doctor.application.exception.exception_enums.ExceptionEnums;
import lombok.Getter;

@Getter
public class ErrorMessage {

    private String ofStatic;
    private ExceptionEnums messageType;

    public ErrorMessage(ExceptionEnums messageType) {
        this.messageType = messageType;
    }

    public String prepareErrorMessage() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageType.getMessageType());

        if (this.ofStatic != null) {
            stringBuilder.append(" :" + ofStatic);

        }
        return stringBuilder.toString();
    }
}
