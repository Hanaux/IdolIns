package com.mju.IdolIns.data.dto.paymentdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangePaymentInfoDto {
    private int docID;
    private int accNum;
    private int CustID;
    private String date;
}
