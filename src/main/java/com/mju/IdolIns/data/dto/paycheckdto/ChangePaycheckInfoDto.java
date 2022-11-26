package com.mju.IdolIns.data.dto.paycheckdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangePaycheckInfoDto {
    private int docID;
    private int paymentReportOK;
    private int paymentCompleted;
}
