package com.hims.appointment.application.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private  ErrorMessage errorMessage;
    private  HttpStatus httpStatus;

    public BaseException(ErrorMessage errorMessage, HttpStatus httpStatus) {
        super(errorMessage.prepareErrorMessage());
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }
    public BaseException(ErrorMessage errorMessage) {
        this.errorMessage=errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
