package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Insurance;
import com.mju.IdolIns.exception.CustomException;

public interface ChargerDao {
    Charger insertCharger(Charger charger) throws CustomException;
    Charger selectCharger(int accident_NM) throws CustomException;
    Charger updateChargerInfo(int accident_NM, int ins_ID, int custID, int lossAmountHuman, int lossAmountProperty) throws Exception;
    void deleteCharger(int Accident_NM) throws Exception;
}
