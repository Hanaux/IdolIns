package com.mju.IdolIns.data.dto.insurancedto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InsuranceDto {
    private String Ins_NM;
    private String Department;
    private String Target_Cust;
    private String Detail;
    private int InsFee;
    private int Rate;
    private int Compensation;
    private int Permission;

}