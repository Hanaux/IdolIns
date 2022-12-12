package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.PaymentDao;
import com.mju.IdolIns.data.dto.paymentdto.PaymentDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentResponseDto;
import com.mju.IdolIns.data.entity.Payment;
import com.mju.IdolIns.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao){
        this.paymentDao = paymentDao;
    }
    @Override
    public PaymentResponseDto getPayment(int pay_id) {
        Payment payment = paymentDao.selectPayment(pay_id);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();

        paymentResponseDto.setPayID(payment.getPayID());
        paymentResponseDto.setDocID(payment.getDocID());
        paymentResponseDto.setDate(payment.getDate());
        paymentResponseDto.setAccNum(payment.getAccNum());
        paymentResponseDto.setChargerNum(payment.getChargerNum());
        paymentResponseDto.setCustID(payment.getCustID());

        return paymentResponseDto;
    }

    @Override
    public PaymentResponseDto savePayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setDocID(paymentDto.getDocID());
        payment.setDate(paymentDto.getDate());
        payment.setAccNum(paymentDto.getAccNum());
        payment.setChargerNum(paymentDto.getChargerNum());
        payment.setCustID(paymentDto.getCustID());

        Payment savedPayment = paymentDao.insertPayment(payment);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();

        paymentResponseDto.setPayID(savedPayment.getPayID());
        paymentResponseDto.setDocID(savedPayment.getDocID());
        paymentResponseDto.setDate(savedPayment.getDate());
        paymentResponseDto.setAccNum(savedPayment.getAccNum());
        paymentResponseDto.setChargerNum(savedPayment.getChargerNum());
        paymentResponseDto.setCustID(savedPayment.getCustID());

        return paymentResponseDto;
    }

    @Override
    public PaymentResponseDto changePaymentInfo(int pay_id, int DocID, String date, int accNum, int chargerNum, int custID) throws Exception {
        Payment changedPayment = paymentDao.updatePaymentInfo(pay_id, DocID, date, accNum, chargerNum, custID);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();

        paymentResponseDto.setPayID(changedPayment.getPayID());
        paymentResponseDto.setDocID(changedPayment.getDocID());
        paymentResponseDto.setDate(changedPayment.getDate());
        paymentResponseDto.setAccNum(changedPayment.getAccNum());
        paymentResponseDto.setChargerNum(changedPayment.getChargerNum());
        paymentResponseDto.setCustID(changedPayment.getCustID());

        return paymentResponseDto;
    }

    @Override
    public void deletePayment(int pay_id) throws Exception {
        paymentDao.deletePayment(pay_id);
    }
}
