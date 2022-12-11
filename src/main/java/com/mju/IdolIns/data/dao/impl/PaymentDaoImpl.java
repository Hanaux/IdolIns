package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.dao.PaymentDao;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Payment;
import com.mju.IdolIns.data.repository.ChargerRepository;
import com.mju.IdolIns.data.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentDaoImpl implements PaymentDao {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentDaoImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment insertPayment(Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment;
    }

    @Override
    public Payment selectPayment(int pay_id) {
        Payment selectedPayment = paymentRepository.getById(pay_id);
        return selectedPayment;
    }

    @Override
    public Payment updatePaymentInfo(int pay_id, int DocID, String date, int accNum, int chargerNum, int custID) throws Exception {
        Optional<Payment> selectedPayment = paymentRepository.findById(pay_id);

        Payment updatePayment;
        if(selectedPayment.isPresent()) {
            Payment payment = selectedPayment.get();

            payment.setDocID(DocID);
            payment.setDate(date);
            payment.setAccNum(accNum);
            payment.setChargerNum(chargerNum);
            payment.setCustID(custID);

            updatePayment = paymentRepository.save(payment);
        }else {
            throw new Exception();
        }
         return updatePayment;
    }

    @Override
    public void deletePayment(int pay_id) throws Exception {
    Optional<Payment> selectedPayment = paymentRepository.findById(pay_id);

    if(selectedPayment.isPresent()){
        Payment payment = selectedPayment.get();
        paymentRepository.delete(payment);
    } else {
        throw new Exception();
    }
    }
}
