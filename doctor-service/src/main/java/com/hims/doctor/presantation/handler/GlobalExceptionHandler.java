package com.hims.doctor.presantation.handler;

import com.hims.doctor.application.exception.BaseException;
import com.hims.doctor.application.exception.ErrorMessage;
import com.hims.doctor.application.exception.exception_enums.ExceptionEnums;
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

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError<?>> handlerBaseException(BaseException ex, HttpServletRequest request) {

        ErrorMessage errorMessage = ex.getErrorMessage();
        ExceptionEnums messageType = errorMessage.getMessageType();

        HttpStatus status;

        switch (messageType) {

            case DOCTOR_NOT_FOUND:
                status = HttpStatus.NOT_FOUND; //404
                break;

            case INVALID_DOCTOR_DATA:
                status = HttpStatus.BAD_REQUEST; //400
                break;
            case DOCTOR_ALREADY_EXISTS:
                status = HttpStatus.CONFLICT; //409

            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;//500

        }
        logger.warn("Handle BaseException: {} at path: {}", errorMessage.prepareErrorMessage(), request.getRequestURI());
        ApiError<?> apiError = createApiError(errorMessage.getMessageType(), status, request.getRequestURI());
        return new ResponseEntity<>(apiError, status);
    }

    //Handle Validation Exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        HttpStatus status = HttpStatus.BAD_REQUEST; //400
        ApiError<Map<String, String>> apiError = createApiError(errors, status, request.getRequestURI());

        return new ResponseEntity<>(apiError, status);
    }


    //Handle General Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError<?>> handleGeneralException(Exception ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500

        logger.error("An unexpected error occurred ", status, request.getRequestURI());

        ApiError<?> apiError = createApiError("An unexpected error occurred", status, request.getRequestURI());

        return new ResponseEntity<>(apiError, status);
    }

    //Create api error
    public <E> ApiError<E> createApiError(E message, HttpStatus httpStatus, String path) {

        ApiError<E> apiError = new ApiError<>();
        apiError.setHttpStatus(httpStatus.value());
        apiError.setMessage(message);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(path);

        return apiError;
    }


}
