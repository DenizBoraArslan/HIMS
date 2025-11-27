package com.hims.patient.presantation.handler;



import com.hims.patient.appilcation.exception.BaseException;
import com.hims.patient.appilcation.exception.ErrorMessage;
import com.hims.patient.appilcation.exception.exception_enums.ExceptionEnums;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {


    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public GlobalExceptionHandler(HttpServletRequest httpServletRequest) {
    }

    //Handle Base Exceptions
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError<?>> handlerBaseException(BaseException ex, HttpServletRequest request) {

        ErrorMessage errorMessage = ex.getErrorMessage();
        ExceptionEnums messageType = errorMessage.getMessageType();

        HttpStatus status;

        switch (messageType) {

            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;//500
        }
        logger.warn("Handle BaseException: {} at path: {}", errorMessage.prepareErrorMessage(), request.getRequestURI());

        ApiError<?> apiError = creaateApiError(errorMessage.getMessageType(), status, request.getRequestURI());

        return new ResponseEntity<>(apiError, status);
    }

    //Handle Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest req) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);

        });

        HttpStatus status = HttpStatus.BAD_REQUEST; // 400
        ApiError<Map<String, String>> apiError = creaateApiError(errors, status, req.getRequestURI());

        return new ResponseEntity<>(apiError, status);
    }

    //Handle General Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError<?>> handlerGeneralException(Exception ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500

        logger.error("An unexpected error occurred ", request.getRequestURI(), ex); // Log the full stack trace

        ApiError<?> apiError = creaateApiError("An unexpected error occurred ", status, request.getRequestURI());

        return new ResponseEntity<>(apiError, status);
    }

    // Create ApiError
    public <E> ApiError<E> creaateApiError(E message, HttpStatus httpStatus, String path) {


        ApiError<E> apiError = new ApiError<>();
        apiError.setHttpStatus(httpStatus.value());
        apiError.setMessage(message);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(path);
        return apiError;

    }

}
