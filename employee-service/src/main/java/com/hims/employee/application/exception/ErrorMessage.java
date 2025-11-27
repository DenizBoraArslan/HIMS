package com.hims.employee.application.exception;

import com.hims.employee.application.exception.excepiton_enums.ExceptionEnums;
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
