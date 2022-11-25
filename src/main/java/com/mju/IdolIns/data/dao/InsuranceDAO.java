package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Insurance;

public interface InsuranceDAO {
    Insurance insertInsurance(Insurance insurance);
    Insurance selectInsurance(int insId);
    Insurance updateInsuranceName(int insId, String insName) throws Exception;
    void deleteInsurance(int insId) throws Exception;
    Insurance updateInsurancePermission(int insId, int permission) throws Exception;
}
