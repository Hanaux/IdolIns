package com.mju.IdolIns.data.dto.chargerdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeChargerInfoDto {
    private int chargerNum;
    private int ins_ID;
    private int custID;
    private int lossAmountHuman;
    private int lossAmountProperty;
}
