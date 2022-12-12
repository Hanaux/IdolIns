package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Paycheck;
import com.mju.IdolIns.exception.CustomException;

public interface PaycheckDao {
    Paycheck insertPaycheck(Paycheck paycheck) throws CustomException;
    Paycheck selectPaycheck(int PayCheckID) throws CustomException;
    Paycheck updatePaycheckInfo(int PayCheckID, int payID, int paymentReportOK, int paymentCompleted) throws CustomException;
    void deletePaycheck(int PayCheckID) throws CustomException;
}
