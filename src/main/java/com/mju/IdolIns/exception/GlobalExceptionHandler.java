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

import static com.mju.IdolIns.exception.ErrorCode.DUPLICATE_RESOURCE;
import static com.mju.IdolIns.exception.ErrorCode.MEMBER_NOT_FOUND;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ConstraintViolationException.class, DataIntegrityViolationException.class})
    protected ResponseEntity<ErrorResponse> handleDataException() {
        log.error("handleDataException throw Exception : {}", DUPLICATE_RESOURCE);
        return ErrorResponse.toResponseEntity(DUPLICATE_RESOURCE);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleCustException() {
        log.error("handleDataException throw Exception : {}", MEMBER_NOT_FOUND);
        return ErrorResponse.toResponseEntity(MEMBER_NOT_FOUND);
    }

    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e){
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
