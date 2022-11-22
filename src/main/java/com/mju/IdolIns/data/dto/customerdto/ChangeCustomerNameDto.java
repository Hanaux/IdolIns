package com.mju.IdolIns.data.dto.customerdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeCustomerNameDto {
    private int cust_ID;
    private String cust_NM;

    public ChangeCustomerNameDto(int cust_ID, String cust_NM){
        this.cust_ID = cust_ID;
        this.cust_NM = cust_NM;
    }
    public ChangeCustomerNameDto(){}
}
