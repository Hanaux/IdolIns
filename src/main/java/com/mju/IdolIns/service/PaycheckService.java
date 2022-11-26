package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.paycheckdto.PaycheckDto;
import com.mju.IdolIns.data.dto.paycheckdto.PaycheckResponseDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentResponseDto;

public interface PaycheckService {
    PaycheckResponseDto getPaycheck(int doc_id);
    PaycheckResponseDto savePaycheck(PaycheckDto paycheckDto);
    PaycheckResponseDto changePaycheckInfo(int docID, int paymentReportOK, int paymentCompleted) throws Exception;
    void deletePaycheck(int doc_id) throws Exception;
}
