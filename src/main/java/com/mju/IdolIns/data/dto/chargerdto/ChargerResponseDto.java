package com.mju.IdolIns.data.dto.chargerdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChargerResponseDto {
    private int Accident_NM;
    private int Ins_ID;
    private int LossAmountHuman;
    private int LossAmountProperty;
    private int DecisionCompensationProperty;
    private int DecisionCompensationHuman;

    private int Cust_ID;
    private int Doc_ID;
    private String Date;
    private int PaymentReportOK;
    private int PaymentCompleted;

}
