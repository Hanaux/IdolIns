package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.repository.ChargerRepository;
import com.mju.IdolIns.exception.CustomException;
import com.mju.IdolIns.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class ChargerDaoImpl implements ChargerDao {

    private final ChargerRepository chargerRepository;

    @Autowired
    public ChargerDaoImpl(ChargerRepository chargerRepository) {
        this.chargerRepository = chargerRepository;
    }

    @Override
    public Charger insertCharger(Charger charger) throws CustomException {
        Charger savedCharger = Optional.of(chargerRepository.save(charger))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedCharger;
    }

    @Override
    public Charger selectCharger(int accident_NM) throws CustomException{
        Charger selectedCharger = Optional.of(chargerRepository.getById(accident_NM))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        return selectedCharger;
    }

    @Override
    public Charger updateChargerInfo(int accident_NM, int ins_ID, int custID, int lossAmountHuman, int lossAmountProperty) throws CustomException {
        Optional<Charger> selectedCharger = Optional.ofNullable(chargerRepository.findById(accident_NM))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

            Charger updateCharger;
            Charger charger = selectedCharger.get();

            charger.setInsid(ins_ID);
            charger.setCustid(custID);
            charger.setLossAmountHuman(lossAmountHuman);
            charger.setLossAmountProperty(lossAmountProperty);

            updateCharger = Optional.of(chargerRepository.save(charger))
                    .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));

         return updateCharger;
    }

    @Override
    public void deleteCharger(int accident_NM) throws CustomException {
    Optional<Charger> selectedCharger = Optional.ofNullable(chargerRepository.findById(accident_NM))
            .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Charger charger = selectedCharger.get();
        try {
            chargerRepository.delete(charger);
        } catch(CustomException e){
            e = new CustomException(COULD_NOT_DELETE);
        }


    }
}
