package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.InsuranceCenter;

public interface InsuranceCenterDao {
    InsuranceCenter insertInsuranceCenter(InsuranceCenter insuranceCenter);
    InsuranceCenter selectInsuranceCenter(int centerNum);
    InsuranceCenter updateInsuranceCenter(int centerNum, String centerName, String centerLocation, String centerAddress) throws Exception;
    void deleteInsuranceCenter(int centerNum) throws Exception;
}
