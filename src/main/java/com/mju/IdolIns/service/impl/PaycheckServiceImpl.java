package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.PaycheckDao;
import com.mju.IdolIns.data.dao.PaymentDao;
import com.mju.IdolIns.data.dto.paycheckdto.PaycheckDto;
import com.mju.IdolIns.data.dto.paycheckdto.PaycheckResponseDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentResponseDto;
import com.mju.IdolIns.data.entity.Paycheck;
import com.mju.IdolIns.data.entity.Payment;
import com.mju.IdolIns.service.PaycheckService;
import com.mju.IdolIns.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaycheckServiceImpl implements PaycheckService {

    private final PaycheckDao paycheckDao;

    @Autowired
    public PaycheckServiceImpl(PaycheckDao paycheckDao){
        this.paycheckDao = paycheckDao;
    }
    @Override
    public PaycheckResponseDto getPaycheck(int docID) {
        Paycheck paycheck = paycheckDao.selectPaycheck(docID);

        PaycheckResponseDto paycheckResponseDto = new PaycheckResponseDto();

        paycheckResponseDto.setDoc_ID(paycheck.getDocID());
        paycheckResponseDto.setPaymentReportOK(paycheck.getPaymentReportOK());
        paycheckResponseDto.setPaymentCompleted(paycheck.getPaymentCompleted());

        return paycheckResponseDto;
    }

    @Override
    public PaycheckResponseDto savePaycheck(PaycheckDto paycheckDto) {
        Paycheck paycheck = new Paycheck();
        paycheck.setPaymentReportOK(paycheckDto.getPaymentReportOK());
        paycheck.setPaymentCompleted(paycheckDto.getPaymentCompleted());

        Paycheck savedPaycheck = paycheckDao.insertPaycheck(paycheck);

        PaycheckResponseDto paycheckResponseDto = new PaycheckResponseDto();

        paycheckResponseDto.setDoc_ID(savedPaycheck.getDocID());
        paycheckResponseDto.setPaymentReportOK(savedPaycheck.getPaymentReportOK());
        paycheckResponseDto.setPaymentCompleted(savedPaycheck.getPaymentCompleted());

        return paycheckResponseDto;
    }

    @Override
    public PaycheckResponseDto changePaycheckInfo(int docID, int paymentReportOK, int paymentCompleted) throws Exception {
        Paycheck changedPaycheck = paycheckDao.updatePaycheckInfo(docID, paymentReportOK, paymentCompleted);

        PaycheckResponseDto paycheckResponseDto = new PaycheckResponseDto();

        paycheckResponseDto.setDoc_ID(changedPaycheck.getDocID());
        paycheckResponseDto.setPaymentReportOK(changedPaycheck.getPaymentReportOK());
        paycheckResponseDto.setPaymentCompleted(changedPaycheck.getPaymentCompleted());

        return paycheckResponseDto;
    }

    @Override
    public void deletePaycheck(int docID) throws Exception {
        paycheckDao.deletePaycheck(docID);
    }
}
