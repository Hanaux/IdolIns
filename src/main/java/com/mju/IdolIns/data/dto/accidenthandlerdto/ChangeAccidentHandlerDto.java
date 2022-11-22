package com.mju.IdolIns.data.dto.accidenthandlerdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeAccidentHandlerDto {
    private int acc_NM;
    private String acc_Spot;
    private String acc_Detail;
    private int cust_ID;
    private int ins_ID;
    private int indemn;
    private int dam_Amount;

    public ChangeAccidentHandlerDto(int acc_NM, String acc_Spot, String acc_Detail,
                                    int cust_ID, int ins_ID, int indemn, int dam_Amount){
        this.acc_NM = acc_NM;
        this.acc_Spot = acc_Spot;
        this.acc_Detail = acc_Detail;
        this.cust_ID = cust_ID;
        this.ins_ID = ins_ID;
        this.indemn = indemn;
        this.dam_Amount = dam_Amount;
    }

    public ChangeAccidentHandlerDto(){}
}
