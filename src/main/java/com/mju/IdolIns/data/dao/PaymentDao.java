package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Payment;

public interface PaymentDao {
    Payment insertPayment(Payment payment);
    Payment selectPayment(int pay_id);
    Payment updatePaymentInfo(int pay_id, int DocID, String date, int accNum, int chargerNum, int custID) throws Exception;
    void deletePayment(int pay_id) throws Exception;
}
