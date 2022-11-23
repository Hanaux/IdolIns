package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.chargerdto.ChargerDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerResponseDto;

public interface ChargerService {
    ChargerResponseDto getCharger(int Accident_NM);
    ChargerResponseDto saveCharger(ChargerDto ChargerDto);
    ChargerResponseDto changeChargerInfo(int accident_NM, int ins_ID, int lossAmountHuman, int lossAmountProperty,
                                         int decisionCompensationProperty, int decisionCompensationHuman, int cust_ID,
                                         int doc_ID, String date, int paymentReportOK, int paymentCompleted) throws Exception;
    void deleteCharger(int Accident_NM) throws Exception;
}
