package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Accident;

public interface AccidentDao {
    Accident insertAccident(Accident accident);
    Accident selectAccident(int accident_NM);
    Accident updateAccident(int accident_NM, String name, String dateOfBirth,
                            int sex, String acc_Detail, String acc_Spot, String phoneNum) throws Exception;
    void deleteAccident(int accident_NM) throws Exception;
}
