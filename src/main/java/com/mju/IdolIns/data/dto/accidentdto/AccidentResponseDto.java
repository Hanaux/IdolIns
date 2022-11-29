package com.mju.IdolIns.data.dto.accidentdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AccidentResponseDto {
    private int Accident_NM;
    private String name;
    private String dateOfBirth;
    private int sex;
    private String accidentDetail;
    private String accidentSpot;
    private String phone_NM;

    public AccidentResponseDto(){}

    public AccidentResponseDto(int accident_NM, String name, String dateOfBirth,
                               int sex, String accidentDetail, String accidentSpot, String phone_NM){
        this.Accident_NM = accident_NM;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.accidentDetail = accidentDetail;
        this.accidentSpot = accidentSpot;
        this.phone_NM = phone_NM;
    }
}
