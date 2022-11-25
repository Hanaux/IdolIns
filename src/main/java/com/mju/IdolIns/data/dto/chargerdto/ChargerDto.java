package com.mju.IdolIns.data.dto.chargerdto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ChargerDto {
    private int Ins_ID;
    private int LossAmountHuman;
    private int LossAmountProperty;

}
