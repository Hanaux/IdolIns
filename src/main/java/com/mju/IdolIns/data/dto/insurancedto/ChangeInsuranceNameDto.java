package com.mju.IdolIns.data.dto.insurancedto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeInsuranceNameDto {
    private int ins_ID;
    private String ins_NM;

    public ChangeInsuranceNameDto(int ins_ID, String ins_NM){
        this.ins_ID = ins_ID;
        this.ins_NM = ins_NM;
    }
    public ChangeInsuranceNameDto(){}
}
