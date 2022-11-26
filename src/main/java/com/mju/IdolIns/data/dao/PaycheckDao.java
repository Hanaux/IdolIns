package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Paycheck;

public interface PaycheckDao {
    Paycheck insertPaycheck(Paycheck paycheck);
    Paycheck selectPaycheck(int docID);
    Paycheck updatePaycheckInfo(int docID, int paymentReportOK, int paymentCompleted) throws Exception;
    void deletePaycheck(int docID) throws Exception;
}
