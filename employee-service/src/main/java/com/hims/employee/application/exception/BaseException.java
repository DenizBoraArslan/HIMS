package com.hims.employee.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
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

}
