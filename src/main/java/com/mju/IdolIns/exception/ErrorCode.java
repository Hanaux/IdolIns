package com.mju.IdolIns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //GLOBAL DATA EXCEPTION
    INTEGRITY_VIOLATION(CONFLICT, "데이터 삽입에서 무결성 제약 조건이 위반되었습니다."),
    CONSTRAINT_VIOLATION(CONFLICT, "제약조건이 위반되었습니다."),

    DATA_NOT_FOUND(NOT_FOUND, "데이터를 찾을 수 없습니다."),
    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다."),
    COULD_NOT_SAVE(NOT_IMPLEMENTED, "데이터 저장에 실패하였습니다."),
    COULD_NOT_DELETE(NOT_MODIFIED, "데이터 삭제에 실패하였습니다."),
    COULD_NOT_UPDATE(NOT_MODIFIED, "데이터 수정에 실패하였습니다."),

    //CUST DATA EXCEPTION
    CUST_INFO_NOT_FOUND(NOT_FOUND, "고객 정보를 찾을 수 없습니다."),
    DUPLICATE_CUST_INFO(CONFLICT, "이미 존재하는 고객 정보입니다."),
    COULD_NOT_SAVE_CUST(NOT_IMPLEMENTED, "고객 정보를 저장하는데 실패하였습니다."),
    COULD_NOT_DELETE_CUST(NOT_MODIFIED, "고객 정보 삭제에 실패하였습니다."),
    COULD_NOT_UPDATE_CUST(NOT_MODIFIED, "고객 정보 수정에 실패하였습니다."),

    //INS DATA EXCEPTION
    INS_INFO_NOT_FOUND(NOT_FOUND, "보험 정보를 찾을 수 없습니다."),
    DUPLICATE_INS_INFO(CONFLICT, "이미 존재하는 보험 정보입니다."),
    COULD_NOT_SAVE_INS(NOT_IMPLEMENTED, "보험 정보를 저장하는데 실패하였습니다."),
    COULD_NOT_DELETE_INS(NOT_MODIFIED, "보험 정보 삭제에 실패하였습니다."),
    COULD_NOT_UPDATE_INS(NOT_MODIFIED, "보험 정보 수정에 실패하였습니다."),

    //CHARGER DATA EXCEPTION
    CHARGER_INFO_NOT_FOUND(NOT_FOUND, "청구 정보를 찾을 수 없습니다."),
    DUPLICATE_CHARGER_INFO(CONFLICT, "이미 존재하는 청구 정보입니다."),
    COULD_NOT_SAVE_CHARGER(NOT_IMPLEMENTED, "청구 정보를 저장하는데 실패하였습니다."),
    COULD_NOT_DELETE_CHARGER(NOT_MODIFIED, "청구 정보 삭제에 실패하였습니다."),
    COULD_NOT_UPDATE_CHARGER(NOT_MODIFIED, "청구 정보 수정에 실패하였습니다."),

    //ACCIDENT DATA EXCEPTION
    ACC_INFO_NOT_FOUND(NOT_FOUND, "사고 정보를 찾을 수 없습니다."),
    DUPLICATE_ACC_INFO(CONFLICT, "이미 존재하는 사고 정보입니다."),
    COULD_NOT_SAVE_ACC(NOT_IMPLEMENTED, "사고 정보를 저장하는데 실패하였습니다."),
    COULD_NOT_DELETE_ACC(NOT_MODIFIED, "사고 정보 삭제에 실패하였습니다."),
    COULD_NOT_UPDATE_ACC(NOT_MODIFIED, "사고 정보 수정에 실패하였습니다."),

    //ACCIDENT_HANDLE DATA EXCEPTION
    ACC_HANDLE_INFO_NOT_FOUND(NOT_FOUND, "사고처리 정보를 찾을 수 없습니다."),
    DUPLICATE_ACC_HANDLE_INFO(CONFLICT, "이미 존재하는 사고처리 정보입니다."),
    COULD_NOT_SAVE_ACC_HANDLE(NOT_IMPLEMENTED, "사고처리 정보를 저장하는데 실패하였습니다."),
    COULD_NOT_DELETE_ACC_HANDLE(NOT_MODIFIED, "사고처리 정보 삭제에 실패하였습니다."),
    COULD_NOT_UPDATE_ACC_HANDLE(NOT_MODIFIED, "사고처리 정보 수정에 실패하였습니다."),

    //CALCULATE_HANDLE DATA EXCEPTION
    CAL_INFO_NOT_FOUND(NOT_FOUND, "보험금 산출 정보를 찾을 수 없습니다."),
    DUPLICATE_CAL_INFO(CONFLICT, "이미 존재하는 보험금 산출 정보입니다."),
    COULD_NOT_SAVE_CAL(NOT_IMPLEMENTED, "보험금 산출 정보를 저장하는데 실패하였습니다."),
    COULD_NOT_DELETE_CAL(NOT_MODIFIED, "보험금 산출 정보 삭제에 실패하였습니다."),
    COULD_NOT_UPDATE_CAL(NOT_MODIFIED, "보험금 산출 정보 수정에 실패하였습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
