package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.chargerdto.ChargerDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerResponseDto;

public interface ChargerService {
    ChargerResponseDto getCharger(int chargerNum);
    ChargerResponseDto saveCharger(ChargerDto ChargerDto);
    ChargerResponseDto changeChargerInfo(int chargerNum, int ins_ID, int cust_ID, int lossAmountHuman, int lossAmountProperty) throws Exception;
    void deleteCharger(int Accident_NM) throws Exception;
}
