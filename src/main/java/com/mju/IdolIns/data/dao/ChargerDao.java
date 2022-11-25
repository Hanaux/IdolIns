package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Insurance;

public interface ChargerDao {
    Charger insertCharger(Charger charger);
    Charger selectCharger(int accident_NM);
    Charger updateChargerInfo(int accident_NM, int ins_ID, int lossAmountHuman, int lossAmountProperty) throws Exception;
    void deleteCharger(int Accident_NM) throws Exception;
}
