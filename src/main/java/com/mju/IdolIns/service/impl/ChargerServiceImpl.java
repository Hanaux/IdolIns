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

        return chargerResponseDto;
    }

    @Override
    public ChargerResponseDto saveCharger(ChargerDto chargerDto) {
        Charger charger = new Charger();
        charger.setInsID(chargerDto.getIns_ID());
        charger.setLossAmountHuman(chargerDto.getLossAmountHuman());
        charger.setLossAmountProperty(chargerDto.getLossAmountProperty());

        Charger savedCharger = chargerDao.insertCharger(charger);

        ChargerResponseDto chargerResponseDto = new ChargerResponseDto();

        chargerResponseDto.setAccident_NM(savedCharger.getAccNum());
        chargerResponseDto.setIns_ID(savedCharger.getInsID());
        chargerResponseDto.setLossAmountHuman(savedCharger.getLossAmountHuman());
        chargerResponseDto.setLossAmountProperty(savedCharger.getLossAmountProperty());

        return chargerResponseDto;
    }

    @Override
    public ChargerResponseDto changeChargerInfo(int accident_NM, int ins_ID, int lossAmountHuman, int lossAmountProperty) throws Exception {
        Charger changedCharger = chargerDao.updateChargerInfo(accident_NM, ins_ID, lossAmountHuman, lossAmountProperty);

        ChargerResponseDto chargerResponseDto = new ChargerResponseDto();

        chargerResponseDto.setAccident_NM(changedCharger.getAccNum());
        chargerResponseDto.setIns_ID(changedCharger.getInsID());
        chargerResponseDto.setLossAmountHuman(changedCharger.getLossAmountHuman());
        chargerResponseDto.setLossAmountProperty(changedCharger.getLossAmountProperty());

        return chargerResponseDto;
    }

    @Override
    public void deleteCharger(int accident_NM) throws Exception {
        chargerDao.deleteCharger(accident_NM);
    }
}
