package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Payment;
import com.mju.IdolIns.exception.CustomException;

public interface PaymentDao {
    Payment insertPayment(Payment payment) throws CustomException;
    Payment selectPayment(int pay_id) throws CustomException;
    Payment updatePaymentInfo(int pay_id, int DocID, String date, int accNum, int chargerNum, int custID) throws CustomException;
    void deletePayment(int pay_id) throws CustomException;
}
