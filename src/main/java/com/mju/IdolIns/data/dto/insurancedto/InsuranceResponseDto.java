package com.mju.IdolIns.data.dto.insurancedto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceResponseDto {
    private int Ins_ID;
    private String Ins_NM;
    private String Department;
    private String Target_Cust;
    private String Detail;
    private int InsFee;
    private int Rate;
    private int Compensation;
    private int Permission;

    public InsuranceResponseDto(){}

    public InsuranceResponseDto(int ins_ID, String ins_NM, String department,
                                String target_Cust, String detail, int insFee, int rate, int compensation, int permission){
        this.Ins_ID = ins_ID;
        this.Ins_NM = ins_NM;
        this.Department = department;
        this.Target_Cust = target_Cust;
        this.Detail = detail;
        this.InsFee = insFee;
        this.Rate = rate;
        this.Compensation = compensation;
        this.Permission = permission;
    }


}