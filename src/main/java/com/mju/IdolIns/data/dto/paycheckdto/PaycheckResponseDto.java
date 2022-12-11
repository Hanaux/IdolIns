package com.mju.IdolIns.data.dto.paycheckdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PaycheckResponseDto {
    private int PayCheckID;
    private int payID;
    private int paymentReportOK;
    private int paymentCompleted;

}
