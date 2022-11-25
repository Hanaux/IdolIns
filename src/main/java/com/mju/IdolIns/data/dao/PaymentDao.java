package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Payment;

public interface PaymentDao {
    Payment insertPayment(Payment payment);
    Payment selectPayment(int docID);
    Payment updatePaymentInfo(int docID, int accNum, int custID, String date) throws Exception;
    void deletePayment(int docID) throws Exception;
}
