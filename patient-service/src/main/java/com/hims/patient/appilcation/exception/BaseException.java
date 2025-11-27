package com.hims.patient.appilcation.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private HttpStatus httpStatus;
    private final ErrorMessage errorMessage;


    public BaseException(ErrorMessage errorMessage, HttpStatus httpStatus) {
        super(errorMessage.prepareErrorMessage());
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public BaseException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }


}
