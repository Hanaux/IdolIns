package com.mju.IdolIns.data.dto.paymentdto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PaymentDto {
    private int DocID;
    private String date;
    private int accNum;
    private int chargerNum;
    private int custID;

}
