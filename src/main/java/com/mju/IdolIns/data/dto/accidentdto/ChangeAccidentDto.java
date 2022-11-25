package com.mju.IdolIns.data.dto.accidentdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeAccidentDto {
    private int accNum;
    private String name;
    private String dateOfBirth;
    private int sex;
    private String accDetail;
    private String accSpot;
    private String phoneNum;

    public ChangeAccidentDto(int accNum, String name, String dateOfBirth,
                             int sex, String accDetail, String accSpot, String phoneNum){
        this.accNum = accNum;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.accDetail = accDetail;
        this.accSpot = accSpot;
        this.phoneNum = phoneNum;
    }
    public ChangeAccidentDto(){}
}
