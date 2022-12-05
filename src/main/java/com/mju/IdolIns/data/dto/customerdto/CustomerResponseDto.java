package com.mju.IdolIns.data.dto.customerdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CustomerResponseDto {
    private int Cust_ID;
    private String Cust_NM;
    private String SSN;
    private String Cust_PN;
    private String Acc_NM;
    private int Sex;

    private String job;

    public CustomerResponseDto(){}

    public CustomerResponseDto(int cust_ID, String cust_NM, String ssn,
                               String cust_PN, String acc_NM, int sex, String job){
        this.Cust_ID = cust_ID;
        this.Cust_NM = cust_NM;
        this.SSN = ssn;
        this.Cust_PN = cust_PN;
        this.Acc_NM = acc_NM;
        this.Sex = sex;
        this.job = job;
    }


}
