package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.paymentdto.PaymentDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto getPayment(int pay_id);
    PaymentResponseDto savePayment(PaymentDto PaymentDto);
    PaymentResponseDto changePaymentInfo(int pay_id, int DocID, String date, int accNum, int chargerNum, int custID) throws Exception;
    void deletePayment(int pay_id) throws Exception;
}
