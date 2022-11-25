package com.mju.IdolIns.data.dto.insurancecenterdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeInsuranceCenterInfoDto {
    private int centerNum;
    private String centerName;
    private String centerLocation;
    private String centerAddress;

    public ChangeInsuranceCenterInfoDto(){}
    public ChangeInsuranceCenterInfoDto(int centerNum, String centerName, String centerLocation, String centerAddress){
        this.centerNum = centerNum;
        this.centerName = centerName;
        this.centerLocation = centerLocation;
        this.centerAddress = centerAddress;
    }
}
