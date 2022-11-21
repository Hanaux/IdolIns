package com.mju.IdolIns.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String Cust_NM;
    private String SSN;
    private String Cust_PN;
    private String Acc_NM;
    private int Sex;

    public CustomerDto(String custNm, String ssn, String custPn,
                       String accNm, int sex){
        this.Cust_NM = custNm;
        this.SSN = ssn;
        this.Cust_PN = custPn;
        this.Acc_NM = accNm;
        this.Sex = sex;
    }
}
