package com.mju.IdolIns.data.dto.paycheckdto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PaycheckDto {
    private int payID;
    private int paymentReportOK;
    private int paymentCompleted;

}
