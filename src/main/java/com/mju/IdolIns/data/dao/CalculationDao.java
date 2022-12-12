package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Calculation;
import com.mju.IdolIns.exception.CustomException;

public interface CalculationDao {
    Calculation insertCalculation(Calculation Calculation) throws CustomException;
    Calculation selectCalculation(int docID) throws CustomException;
    Calculation updateCalculationInfo(int docID, int accident_NM, int decisionCompensationProperty, int decisionCompensationHuman) throws CustomException;
    void deleteCalculation(int docID) throws CustomException;
}
