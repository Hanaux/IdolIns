package com.mju.IdolIns.data.dto.chargerdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChargerResponseDto {
    private int chargerNum;
    private int Ins_ID;
    private int custID;
    private int LossAmountHuman;
    private int LossAmountProperty;

}
