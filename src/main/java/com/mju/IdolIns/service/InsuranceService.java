package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.insurancedto.InsuranceDto;
import com.mju.IdolIns.data.dto.insurancedto.InsuranceResponseDto;

public interface InsuranceService {
    InsuranceResponseDto getInsurance(int ins_ID);
    InsuranceResponseDto saveInsurance(InsuranceDto insuranceDto);
    InsuranceResponseDto changeInsuranceName(int ins_ID, String ins_NM) throws Exception;
    void deleteInsurance(int ins_ID) throws Exception;
    InsuranceResponseDto changeInsurancePermission(int ins_ID, int permission) throws Exception;
}
