package com.mju.IdolIns.data.dto.accidenthandlerdto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AccidentHandlerDto {
    private String Accident_Spot;
    private String Accident_Detail;
    private int Cust_ID;
    private int Ins_ID;
    private int Indemnification;
    private int Damage_Amount;
}
