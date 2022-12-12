package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.PaycheckDao;
import com.mju.IdolIns.data.dao.PaymentDao;
import com.mju.IdolIns.data.entity.Paycheck;
import com.mju.IdolIns.data.entity.Payment;
import com.mju.IdolIns.data.repository.PaycheckRepository;
import com.mju.IdolIns.data.repository.PaymentRepository;
import com.mju.IdolIns.exception.CustomException;
import com.mju.IdolIns.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class PaycheckDaoImpl implements PaycheckDao {

    private final PaycheckRepository paycheckRepository;

    @Autowired
    public PaycheckDaoImpl(PaycheckRepository paycheckRepository) {
        this.paycheckRepository = paycheckRepository;
    }

    @Override
    public Paycheck insertPaycheck(Paycheck paycheck) throws CustomException {
        Paycheck savedPaycheck = Optional.of(paycheckRepository.save(paycheck))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedPaycheck;
    }

    @Override
    public Paycheck selectPaycheck(int PayCheckID) throws CustomException{
        Paycheck selectedPaycheck = Optional.of(paycheckRepository.getById(PayCheckID))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        return selectedPaycheck;
    }

    @Override
    public Paycheck updatePaycheckInfo(int PayCheckID, int payID, int paymentReportOK, int paymentCompleted) throws CustomException {
        Optional<Paycheck> selectedPaycheck = Optional.ofNullable(paycheckRepository.findById(PayCheckID))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Paycheck updatePaycheck;
            Paycheck paycheck = selectedPaycheck.get();

            paycheck.setPaymentReportOK(paymentReportOK);
            paycheck.setPaymentCompleted(paymentCompleted);

            updatePaycheck = Optional.of(paycheckRepository.save(paycheck))
                    .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));

         return updatePaycheck;
    }

    @Override
    public void deletePaycheck(int PayCheckID) throws CustomException{
    Optional<Paycheck> selectedPaycheck = Optional.ofNullable(paycheckRepository.findById(PayCheckID))
            .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Paycheck paycheck = selectedPaycheck.get();

        try {
            paycheckRepository.delete(paycheck);
        } catch (CustomException e) {
            e = new CustomException(COULD_NOT_DELETE);
        }


    }
}
