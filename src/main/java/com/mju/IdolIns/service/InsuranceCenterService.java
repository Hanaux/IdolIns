package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.insurancecenterdto.InsuranceCenterDto;
import com.mju.IdolIns.data.dto.insurancecenterdto.InsuranceCenterResponseDto;
import com.mju.IdolIns.data.entity.InsuranceCenter;
import com.mju.IdolIns.data.repository.InsuranceCenterRepository;

public interface InsuranceCenterService {
    InsuranceCenterResponseDto getInsuranceCenter(int centerNum);
    InsuranceCenterResponseDto saveInsuranceCenter(InsuranceCenterDto insuranceCenterDto);
    InsuranceCenterResponseDto changeInsuranceCenterInfo(int centerNum, String centerName,
                                                         String centerLocation, String centerAddress) throws Exception;
    void deleteInsuranceCenter(int centerNum) throws Exception;
}
