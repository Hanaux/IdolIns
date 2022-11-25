package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.calculationdto.CalculationDto;
import com.mju.IdolIns.data.dto.calculationdto.CalculationResponseDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerResponseDto;

public interface CalculationService {
    CalculationResponseDto getCalculation(int Accident_NM);
    CalculationResponseDto saveCalculation(CalculationDto CalculationDto);
    CalculationResponseDto changeCalculationInfo(int accident_NM, int decisionCompensationProperty, int decisionCompensationHuman) throws Exception;
    void deleteCalculation(int Accident_NM) throws Exception;

}
