package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Accident;
import com.mju.IdolIns.exception.CustomException;

public interface AccidentDao {
    Accident insertAccident(Accident accident) throws CustomException;
    Accident selectAccident(int accident_NM) throws CustomException;
    Accident updateAccident(int accident_NM, String name, String dateOfBirth,
                            int sex, String acc_Detail, String acc_Spot, String phoneNum) throws CustomException;
    void deleteAccident(int accident_NM) throws CustomException;
}
