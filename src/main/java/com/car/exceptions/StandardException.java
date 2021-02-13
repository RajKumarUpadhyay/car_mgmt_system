package com.car.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StandardException extends ResponseEntityExceptionHandler {

    public static final Logger logger = Logger.getLogger(StandardException.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> findAllResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                   WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(resourceNotFoundException.getMessage());
        logger.error("Error Response From Service " + errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> findAllException(Exception exception,
                                                                   WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(exception.getMessage());
        logger.error("Error Response From Service " + errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
