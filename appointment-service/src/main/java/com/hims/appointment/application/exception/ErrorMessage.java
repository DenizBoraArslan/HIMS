package com.hims.appointment.application.exception;

import com.hims.appointment.application.exception.exception_enums.ExceptionEnums;
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

        if(this.ofStatic != null) {
            stringBuilder.append(" :").append(ofStatic);
        }
        return stringBuilder.toString();
    }

}
