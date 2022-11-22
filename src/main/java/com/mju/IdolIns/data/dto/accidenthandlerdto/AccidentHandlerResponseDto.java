package com.mju.IdolIns.data.dto.accidenthandlerdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AccidentHandlerResponseDto {
    private int Accident_NM;
    private String Accident_Spot;
    private String Accident_Detail;
    private int Cust_ID;
    private int Ins_ID;
    private int Indemnification;
    private int Damage_Amount;

    public AccidentHandlerResponseDto(){}

    public AccidentHandlerResponseDto(int accident_NM, String accident_Spot, String accident_Detail,
                                      int cust_ID, int ins_ID, int indemnification, int damage_Amount){
        this.Accident_NM = accident_NM;
        this.Accident_Spot = accident_Spot;
        this.Accident_Detail = accident_Detail;
        this.Cust_ID = cust_ID;
        this.Ins_ID = ins_ID;
        this.Indemnification = indemnification;
        this.Damage_Amount = damage_Amount;
    }
}
