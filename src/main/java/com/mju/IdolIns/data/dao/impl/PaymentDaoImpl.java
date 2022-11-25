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
    public Payment selectPayment(int docID) {
        Payment selectedPayment = paymentRepository.getById(docID);
        return selectedPayment;
    }

    @Override
    public Payment updatePaymentInfo(int docID, int accNum, int custID,  String date) throws Exception {
        Optional<Payment> selectedPayment = paymentRepository.findById(accNum);

        Payment updatePayment;
        if(selectedPayment.isPresent()) {
            Payment payment = selectedPayment.get();

            payment.setAccNum(accNum);
            payment.setCustID(custID);
            payment.setDate(date);

            updatePayment = paymentRepository.save(payment);
        }else {
            throw new Exception();
        }
         return updatePayment;
    }

    @Override
    public void deletePayment(int docID) throws Exception {
    Optional<Payment> selectedPayment = paymentRepository.findById(docID);

    if(selectedPayment.isPresent()){
        Payment payment = selectedPayment.get();
        paymentRepository.delete(payment);
    } else {
        throw new Exception();
    }
    }
}
