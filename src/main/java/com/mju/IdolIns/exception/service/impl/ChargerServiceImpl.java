package com.mju.IdolIns.exception.service.impl;

import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.dto.chargerdto.ChargerDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerResponseDto;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.exception.service.ChargerService;
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
    public ChargerResponseDto getCharger(int ChargerNum) {
        Charger charger = chargerDao.selectCharger(ChargerNum);

        ChargerResponseDto chargerResponseDto = new ChargerResponseDto();

        chargerResponseDto.setChargerNum(charger.getChargerNum());
        chargerResponseDto.setIns_ID(charger.getInsid());
        chargerResponseDto.setCustID(charger.getCustid());
        chargerResponseDto.setLossAmountHuman(charger.getLossAmountHuman());
        chargerResponseDto.setLossAmountProperty(charger.getLossAmountProperty());

        return chargerResponseDto;
    }

    @Override
    public ChargerResponseDto saveCharger(ChargerDto chargerDto) {
        Charger charger = new Charger();
        charger.setInsid(chargerDto.getIns_ID());
        charger.setCustid(chargerDto.getCustID());
        charger.setLossAmountHuman(chargerDto.getLossAmountHuman());
        charger.setLossAmountProperty(chargerDto.getLossAmountProperty());

        Charger savedCharger = chargerDao.insertCharger(charger);

        ChargerResponseDto chargerResponseDto = new ChargerResponseDto();

        chargerResponseDto.setChargerNum(savedCharger.getChargerNum());
        chargerResponseDto.setIns_ID(savedCharger.getInsid());
        chargerResponseDto.setCustID(savedCharger.getCustid());
        chargerResponseDto.setLossAmountHuman(savedCharger.getLossAmountHuman());
        chargerResponseDto.setLossAmountProperty(savedCharger.getLossAmountProperty());

        return chargerResponseDto;
    }

    @Override
    public ChargerResponseDto changeChargerInfo(int ChargerNum, int ins_ID, int custID, int lossAmountHuman, int lossAmountProperty) throws Exception {
        Charger changedCharger = chargerDao.updateChargerInfo(ChargerNum, ins_ID, custID, lossAmountHuman, lossAmountProperty);

        ChargerResponseDto chargerResponseDto = new ChargerResponseDto();

        chargerResponseDto.setChargerNum(changedCharger.getChargerNum());
        chargerResponseDto.setIns_ID(changedCharger.getInsid());
        chargerResponseDto.setCustID(changedCharger.getCustid());
        chargerResponseDto.setLossAmountHuman(changedCharger.getLossAmountHuman());
        chargerResponseDto.setLossAmountProperty(changedCharger.getLossAmountProperty());

        return chargerResponseDto;
    }

    @Override
    public void deleteCharger(int accident_NM) throws Exception {
        chargerDao.deleteCharger(accident_NM);
    }
}
