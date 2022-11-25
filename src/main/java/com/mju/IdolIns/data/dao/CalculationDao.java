package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Calculation;

public interface CalculationDao {
    Calculation insertCalculation(Calculation Calculation);
    Calculation selectCalculation(int accident_NM);
    Calculation updateCalculationInfo(int accident_NM, int decisionCompensationProperty, int decisionCompensationHuman) throws Exception;
    void deleteCalculation(int Accident_NM) throws Exception;
}
