package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.dao.PaymentDao;
import com.mju.IdolIns.data.dto.chargerdto.ChargerDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerResponseDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentResponseDto;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Payment;
import com.mju.IdolIns.service.ChargerService;
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
    public PaymentResponseDto getPayment(int docID) {
        Payment payment = paymentDao.selectPayment(docID);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();

        paymentResponseDto.setDoc_ID(payment.getDocID());
        paymentResponseDto.setAccNum(payment.getAccNum());
        paymentResponseDto.setCust_ID(payment.getCustID());
        paymentResponseDto.setDate(payment.getDate());

        return paymentResponseDto;
    }

    @Override
    public PaymentResponseDto savePayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setAccNum(paymentDto.getAccNum());
        payment.setCustID(paymentDto.getCustID());
        payment.setDate(paymentDto.getDate());

        Payment savedPayment = paymentDao.insertPayment(payment);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();

        paymentResponseDto.setDoc_ID(savedPayment.getDocID());
        paymentResponseDto.setAccNum(savedPayment.getAccNum());
        paymentResponseDto.setCust_ID(savedPayment.getCustID());
        paymentResponseDto.setDate(savedPayment.getDate());

        return paymentResponseDto;
    }

    @Override
    public PaymentResponseDto changePaymentInfo(int docID, int accident_NM, int custID, String date) throws Exception {
        Payment changedPayment = paymentDao.updatePaymentInfo(docID, accident_NM, custID, date);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();

        paymentResponseDto.setDoc_ID(changedPayment.getDocID());
        paymentResponseDto.setAccNum(changedPayment.getAccNum());
        paymentResponseDto.setCust_ID(changedPayment.getCustID());
        paymentResponseDto.setDate(changedPayment.getDate());

        return paymentResponseDto;
    }

    @Override
    public void deletePayment(int docID) throws Exception {
        paymentDao.deletePayment(docID);
    }
}
