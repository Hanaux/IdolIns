package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.InsuranceCenter;
import com.mju.IdolIns.exception.CustomException;

import java.util.List;

public interface InsuranceCenterDao {
    InsuranceCenter insertInsuranceCenter(InsuranceCenter insuranceCenter) throws CustomException;
    InsuranceCenter selectInsuranceCenter(int centerNum) throws CustomException;
    List<InsuranceCenter> getAllInsuranceCenter() throws CustomException;
    InsuranceCenter updateInsuranceCenter(int centerNum, String centerName, String centerLocation, String centerAddress, String centerHotline) throws CustomException;
    void deleteInsuranceCenter(int centerNum) throws CustomException;
}
