package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Insurance;
import com.mju.IdolIns.exception.CustomException;

public interface InsuranceDao {
    Insurance insertInsurance(Insurance insurance) throws CustomException;
    Insurance selectInsurance(int insId) throws CustomException;
    Insurance updateInsuranceName(int insId, String insName) throws CustomException;
    void deleteInsurance(int insId) throws CustomException;
    Insurance updateInsurancePermission(int insId, int permission) throws CustomException;
}
