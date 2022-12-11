package com.mju.IdolIns.data.dto.paymentdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangePaymentInfoDto {
    private int PayID;
    private int DocID;
    private String date;
    private int accNum;
    private int chargerNum;
    private int custID;
}
