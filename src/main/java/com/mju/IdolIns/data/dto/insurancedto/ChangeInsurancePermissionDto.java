package com.mju.IdolIns.data.dto.insurancedto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeInsurancePermissionDto {
    private int ins_ID;
    private int permission;

    public ChangeInsurancePermissionDto(int ins_ID, int permission){
        this.ins_ID = ins_ID;
        this.permission = permission;
    }
}
