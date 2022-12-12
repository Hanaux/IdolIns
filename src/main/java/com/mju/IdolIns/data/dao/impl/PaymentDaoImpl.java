package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.dao.PaymentDao;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Payment;
import com.mju.IdolIns.data.repository.ChargerRepository;
import com.mju.IdolIns.data.repository.PaymentRepository;
import com.mju.IdolIns.exception.CustomException;
import com.mju.IdolIns.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class PaymentDaoImpl implements PaymentDao {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentDaoImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment insertPayment(Payment payment) throws CustomException {
        Payment savedPayment = Optional.of(paymentRepository.save(payment))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedPayment;
    }

    @Override
    public Payment selectPayment(int pay_id) throws CustomException{
        Payment selectedPayment = Optional.of(paymentRepository.getById(pay_id))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        return selectedPayment;
    }

    @Override
    public Payment updatePaymentInfo(int pay_id, int DocID, String date, int accNum, int chargerNum, int custID) throws CustomException {
        Optional<Payment> selectedPayment = Optional.ofNullable(paymentRepository.findById(pay_id))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Payment updatePayment;
            Payment payment = selectedPayment.get();

            payment.setDocID(DocID);
            payment.setDate(date);
            payment.setAccNum(accNum);
            payment.setChargerNum(chargerNum);
            payment.setCustID(custID);

            updatePayment = Optional.of(paymentRepository.save(payment))
                    .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));

         return updatePayment;
    }

    @Override
    public void deletePayment(int pay_id) throws CustomException{
    Optional<Payment> selectedPayment = Optional.ofNullable(paymentRepository.findById(pay_id))
            .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Payment payment = selectedPayment.get();
        try {
            paymentRepository.delete(payment);
        } catch (CustomException e){
            e = new CustomException(COULD_NOT_DELETE);
        }


    }
}
