package com.mju.IdolIns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter@AllArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
}
