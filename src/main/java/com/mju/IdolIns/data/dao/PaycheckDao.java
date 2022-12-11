package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Paycheck;

public interface PaycheckDao {
    Paycheck insertPaycheck(Paycheck paycheck);
    Paycheck selectPaycheck(int PayCheckID);
    Paycheck updatePaycheckInfo(int PayCheckID, int payID, int paymentReportOK, int paymentCompleted) throws Exception;
    void deletePaycheck(int PayCheckID) throws Exception;
}
