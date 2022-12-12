package com.mju.IdolIns.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.ErrorsMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import static com.mju.IdolIns.exception.ErrorCode.*;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<ErrorResponse> handleDataException() {
        log.error("handleDataException throw Exception : {}", INTEGRITY_VIOLATION);
        return ErrorResponse.toResponseEntity(INTEGRITY_VIOLATION);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<ErrorResponse> handleConstException() {
        log.error("handleDataException throw Exception : {}", CONSTRAINT_VIOLATION);
        return ErrorResponse.toResponseEntity(CONSTRAINT_VIOLATION);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleEntityException() {
        log.error("handleDataException throw Exception : {}", DATA_NOT_FOUND);
        return ErrorResponse.toResponseEntity(DATA_NOT_FOUND);
    }

    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e){
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
