package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.dto.chargerdto.ChargerDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerResponseDto;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.service.ChargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargerServiceImpl implements ChargerService {

    private final ChargerDao chargerDao;

    @Autowired
    public ChargerServiceImpl(ChargerDao chargerDao){
        this.chargerDao = chargerDao;
    }
    @Override
    public ChargerResponseDto getCharger(int accident_NM) {
        Charger charger = chargerDao.selectCharger(accident_NM);

        ChargerResponseDto chargerResponseDto = new ChargerResponseDto();

        chargerResponseDto.setAccident_NM(charger.getAccNum());
        chargerResponseDto.setIns_ID(charger.getInsID());
        chargerResponseDto.setLossAmountHuman(charger.getLossAmountHuman());
        chargerResponseDto.setLossAmountProperty(charger.getLossAmountProperty());
        chargerResponseDto.setDecisionCompensationProperty(charger.getDecisionCompensationProperty());
        chargerResponseDto.setDecisionCompensationHuman(charger.getDecisionCompensationHuman());
        chargerResponseDto.setCust_ID(charger.getCustID());
        chargerResponseDto.setDoc_ID(charger.getDocID());
        chargerResponseDto.setDate(charger.getDate());
        chargerResponseDto.setPaymentReportOK(charger.getPaymentReportOK());
        chargerResponseDto.setPaymentCompleted(charger.getPaymentCompleted());

        return chargerResponseDto;
    }

    @Override
    public ChargerResponseDto saveCharger(ChargerDto chargerDto) {
        Charger charger = new Charger();
        charger.setInsID(chargerDto.getIns_ID());
        charger.setLossAmountHuman(chargerDto.getLossAmountHuman());
        charger.setLossAmountProperty(chargerDto.getLossAmountProperty());
        charger.setDecisionCompensationProperty(chargerDto.getDecisionCompensationProperty());
        charger.setDecisionCompensationHuman(chargerDto.getDecisionCompensationHuman());
        charger.setCustID(chargerDto.getCust_ID());
        charger.setDocID(chargerDto.getDoc_ID());
        charger.setDate(chargerDto.getDate());
        charger.setPaymentReportOK(chargerDto.getPaymentReportOK());
        charger.setPaymentCompleted(chargerDto.getPaymentCompleted());

        Charger savedCharger = chargerDao.insertCharger(charger);

        ChargerResponseDto chargerResponseDto = new ChargerResponseDto();

        chargerResponseDto.setAccident_NM(savedCharger.getAccNum());
        chargerResponseDto.setIns_ID(savedCharger.getInsID());
        chargerResponseDto.setLossAmountHuman(savedCharger.getLossAmountHuman());
        chargerResponseDto.setLossAmountProperty(savedCharger.getLossAmountProperty());
        chargerResponseDto.setDecisionCompensationProperty(savedCharger.getDecisionCompensationProperty());
        chargerResponseDto.setDecisionCompensationHuman(savedCharger.getDecisionCompensationHuman());
        chargerResponseDto.setCust_ID(savedCharger.getCustID());
        chargerResponseDto.setDoc_ID(savedCharger.getDocID());
        chargerResponseDto.setDate(savedCharger.getDate());
        chargerResponseDto.setPaymentReportOK(savedCharger.getPaymentReportOK());
        chargerResponseDto.setPaymentCompleted(savedCharger.getPaymentCompleted());

        return chargerResponseDto;
    }

    @Override
    public ChargerResponseDto changeChargerInfo(int accident_NM, int ins_ID, int lossAmountHuman, int lossAmountProperty,
                                                int decisionCompensationProperty, int decisionCompensationHuman, int cust_ID,
                                                int doc_ID, String date, int paymentReportOK, int paymentCompleted) throws Exception {
        Charger changedCharger = chargerDao.updateChargerInfo(accident_NM, ins_ID, lossAmountHuman, lossAmountProperty,
                decisionCompensationProperty, decisionCompensationHuman, cust_ID, doc_ID, date, paymentReportOK, paymentCompleted);

        ChargerResponseDto chargerResponseDto = new ChargerResponseDto();

        chargerResponseDto.setAccident_NM(changedCharger.getAccNum());
        chargerResponseDto.setIns_ID(changedCharger.getInsID());
        chargerResponseDto.setLossAmountHuman(changedCharger.getLossAmountHuman());
        chargerResponseDto.setLossAmountProperty(changedCharger.getLossAmountProperty());
        chargerResponseDto.setDecisionCompensationProperty(changedCharger.getDecisionCompensationProperty());
        chargerResponseDto.setDecisionCompensationHuman(changedCharger.getDecisionCompensationHuman());
        chargerResponseDto.setCust_ID(changedCharger.getCustID());
        chargerResponseDto.setDoc_ID(changedCharger.getDocID());
        chargerResponseDto.setDate(changedCharger.getDate());
        chargerResponseDto.setPaymentReportOK(changedCharger.getPaymentReportOK());
        chargerResponseDto.setPaymentCompleted(changedCharger.getPaymentCompleted());

        return chargerResponseDto;
    }

    @Override
    public void deleteCharger(int accident_NM) throws Exception {
        chargerDao.deleteCharger(accident_NM);
    }
}
