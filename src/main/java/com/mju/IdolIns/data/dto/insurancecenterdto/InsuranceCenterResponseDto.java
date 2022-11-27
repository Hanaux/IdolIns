package com.mju.IdolIns.data.dto.insurancecenterdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class InsuranceCenterResponseDto {
    private int centerNum;
    private String centerName;
    private String centerLocation;
    private String centerAddress;
    private String centerHotline;

    public InsuranceCenterResponseDto(){}

    public InsuranceCenterResponseDto(int centerNum, String centerName, String centerLocation, String centerAddress,
                                      String centerHotline){
        this.centerNum = centerNum;
        this.centerName = centerName;
        this.centerLocation = centerLocation;
        this.centerAddress = centerAddress;
        this.centerHotline = centerHotline;
    }
}
