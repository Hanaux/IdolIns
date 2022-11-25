package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.paymentdto.PaymentDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto getPayment(int doc_id);
    PaymentResponseDto savePayment(PaymentDto PaymentDto);
    PaymentResponseDto changePaymentInfo(int docID, int accNum, int custID, String date) throws Exception;
    void deletePayment(int doc_id) throws Exception;
}
