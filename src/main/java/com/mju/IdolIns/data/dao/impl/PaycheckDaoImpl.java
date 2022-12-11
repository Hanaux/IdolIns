package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.PaycheckDao;
import com.mju.IdolIns.data.dao.PaymentDao;
import com.mju.IdolIns.data.entity.Paycheck;
import com.mju.IdolIns.data.entity.Payment;
import com.mju.IdolIns.data.repository.PaycheckRepository;
import com.mju.IdolIns.data.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaycheckDaoImpl implements PaycheckDao {

    private final PaycheckRepository paycheckRepository;

    @Autowired
    public PaycheckDaoImpl(PaycheckRepository paycheckRepository) {
        this.paycheckRepository = paycheckRepository;
    }

    @Override
    public Paycheck insertPaycheck(Paycheck paycheck) {
        Paycheck savedPaycheck = paycheckRepository.save(paycheck);
        return savedPaycheck;
    }

    @Override
    public Paycheck selectPaycheck(int docID) {
        Paycheck selectedPaycheck = paycheckRepository.getById(docID);
        return selectedPaycheck;
    }

    @Override
    public Paycheck updatePaycheckInfo(int docID, int paymentReportOK, int paymentCompleted) throws Exception {
        Optional<Paycheck> selectedPaycheck = paycheckRepository.findById(docID);

        Paycheck updatePaycheck;
        if(selectedPaycheck.isPresent()) {
            Paycheck paycheck = selectedPaycheck.get();

            paycheck.setPaymentReportOK(paymentReportOK);
            paycheck.setPaymentCompleted(paymentCompleted);

            updatePaycheck = paycheckRepository.save(paycheck);
        }else {
            throw new Exception();
        }
         return updatePaycheck;
    }

    @Override
    public void deletePaycheck(int docID) throws Exception {
    Optional<Paycheck> selectedPaycheck = paycheckRepository.findById(docID);

    if(selectedPaycheck.isPresent()){
        Paycheck paycheck = selectedPaycheck.get();
        paycheckRepository.delete(paycheck);
    } else {
        throw new Exception();
    }
    }
}