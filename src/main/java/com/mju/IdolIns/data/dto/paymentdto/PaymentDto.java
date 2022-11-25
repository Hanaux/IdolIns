package com.mju.IdolIns.data.dto.paymentdto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PaymentDto {
    private int AccNum;
    private int CustID;
    private String Date;

}
