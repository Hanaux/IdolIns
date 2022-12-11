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
    public PaycheckResponseDto getPaycheck(int PayCheckID) {
        Paycheck paycheck = paycheckDao.selectPaycheck(PayCheckID);

        PaycheckResponseDto paycheckResponseDto = new PaycheckResponseDto();

        paycheckResponseDto.setPayCheckID(paycheck.getPayCheckID());
        paycheckResponseDto.setPayID(paycheck.getPayID());
        paycheckResponseDto.setPaymentReportOK(paycheck.getPaymentReportOK());
        paycheckResponseDto.setPaymentCompleted(paycheck.getPaymentCompleted());

        return paycheckResponseDto;
    }

    @Override
    public PaycheckResponseDto savePaycheck(PaycheckDto paycheckDto) {
        Paycheck paycheck = new Paycheck();
        paycheck.setPayID(paycheckDto.getPayID());
        paycheck.setPaymentReportOK(paycheckDto.getPaymentReportOK());
        paycheck.setPaymentCompleted(paycheckDto.getPaymentCompleted());

        Paycheck savedPaycheck = paycheckDao.insertPaycheck(paycheck);

        PaycheckResponseDto paycheckResponseDto = new PaycheckResponseDto();

        paycheckResponseDto.setPayCheckID(savedPaycheck.getPayCheckID());
        paycheckResponseDto.setPayID(savedPaycheck.getPayID());
        paycheckResponseDto.setPaymentReportOK(savedPaycheck.getPaymentReportOK());
        paycheckResponseDto.setPaymentCompleted(savedPaycheck.getPaymentCompleted());

        return paycheckResponseDto;
    }

    @Override
    public PaycheckResponseDto changePaycheckInfo(int PayCheckID, int payID, int paymentReportOK, int paymentCompleted) throws Exception {
        Paycheck changedPaycheck = paycheckDao.updatePaycheckInfo(PayCheckID, payID, paymentReportOK, paymentCompleted);

        PaycheckResponseDto paycheckResponseDto = new PaycheckResponseDto();

        paycheckResponseDto.setPayCheckID(changedPaycheck.getPayCheckID());
        paycheckResponseDto.setPayID(changedPaycheck.getPayID());
        paycheckResponseDto.setPaymentReportOK(changedPaycheck.getPaymentReportOK());
        paycheckResponseDto.setPaymentCompleted(changedPaycheck.getPaymentCompleted());

        return paycheckResponseDto;
    }

    @Override
    public void deletePaycheck(int PayCheckID) throws Exception {
        paycheckDao.deletePaycheck(PayCheckID);
    }
}
