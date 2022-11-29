package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.InsuranceCenter;

import java.util.List;

public interface InsuranceCenterDao {
    InsuranceCenter insertInsuranceCenter(InsuranceCenter insuranceCenter);
    InsuranceCenter selectInsuranceCenter(int centerNum);
    List<InsuranceCenter> getAllInsuranceCenter();
    InsuranceCenter updateInsuranceCenter(int centerNum, String centerName, String centerLocation, String centerAddress, String centerHotline) throws Exception;
    void deleteInsuranceCenter(int centerNum) throws Exception;
}
