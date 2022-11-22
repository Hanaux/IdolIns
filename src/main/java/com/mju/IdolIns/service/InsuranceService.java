package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.InsuranceDto;
import com.mju.IdolIns.data.dto.InsuranceResponseDto;

public interface InsuranceService {
    InsuranceResponseDto getInsurance(int ins_ID);
    InsuranceResponseDto saveInsurance(InsuranceDto insuranceDto);
    InsuranceResponseDto changeInsuranceName(int ins_ID, String ins_NM) throws Exception;
    void deleteInsurance(int ins_ID) throws Exception;
}
