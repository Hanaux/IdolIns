package com.mju.IdolIns.data.dto.chargerdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeChargerInfoDto {
    private int acc_NM;
    private int ins_ID;
    private int lossAmountHuman;
    private int lossAmountProperty;
    private int decisionCompensationProperty;
    private int decisionCompensationHuman;
    private int cust_ID;
    private int doc_ID;
    private String date;
    private int paymentReportOK;
    private int paymentCompleted;

    public ChangeChargerInfoDto(int accident_NM, int ins_ID, int lossAmountHuman, int lossAmountProperty,
                                int decisionCompensationProperty, int decisionCompensationHuman, int cust_ID,
                                int doc_ID, String date, int paymentReportOK, int paymentCompleted){

        this.acc_NM = accident_NM;
        this.ins_ID = ins_ID;
        this.lossAmountHuman = lossAmountHuman;
        this.lossAmountProperty = lossAmountProperty;
        this.decisionCompensationProperty = decisionCompensationProperty;
        this.decisionCompensationHuman = decisionCompensationHuman;
        this.cust_ID = cust_ID;
        this.doc_ID = doc_ID;
        this.date = date;
        this.paymentReportOK = paymentReportOK;
        this.paymentCompleted = paymentCompleted;
    }
    public ChangeChargerInfoDto(){}
}
