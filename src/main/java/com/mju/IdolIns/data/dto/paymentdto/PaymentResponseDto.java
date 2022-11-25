package com.mju.IdolIns.data.dto.paymentdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PaymentResponseDto {
    private int Doc_ID;
    private int AccNum;
    private int Cust_ID;
    private String Date;

}
