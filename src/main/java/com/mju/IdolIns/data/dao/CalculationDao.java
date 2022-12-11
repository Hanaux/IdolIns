package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Calculation;

public interface CalculationDao {
    Calculation insertCalculation(Calculation Calculation);
    Calculation selectCalculation(int docID);
    Calculation updateCalculationInfo(int docID, int accident_NM, int decisionCompensationProperty, int decisionCompensationHuman) throws Exception;
    void deleteCalculation(int docID) throws Exception;
}
