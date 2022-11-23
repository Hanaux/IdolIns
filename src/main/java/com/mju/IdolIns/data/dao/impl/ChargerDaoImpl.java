package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.dao.InsuranceDAO;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.entity.Insurance;
import com.mju.IdolIns.data.repository.ChargerRepository;
import com.mju.IdolIns.data.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ChargerDaoImpl implements ChargerDao {

    private final ChargerRepository chargerRepository;

    @Autowired
    public ChargerDaoImpl(ChargerRepository chargerRepository) {
        this.chargerRepository = chargerRepository;
    }

    @Override
    public Charger insertCharger(Charger charger) {
        Charger savedCharger = chargerRepository.save(charger);
        return savedCharger;
    }

    @Override
    public Charger selectCharger(int accident_NM) {
        Charger selectedCharger = chargerRepository.getById(accident_NM);
        return selectedCharger;
    }

    @Override
    public Charger updateChargerInfo(int accident_NM, int ins_ID, int lossAmountHuman, int lossAmountProperty,
                                   int decisionCompensationProperty, int decisionCompensationHuman, int cust_ID,
                                   int doc_ID, String date, int paymentReportOK, int paymentCompleted) throws Exception {
        Optional<Charger> selectedCharger = chargerRepository.findById(accident_NM);

        Charger updateCharger;
        if(selectedCharger.isPresent()) {
            Charger charger = selectedCharger.get();

            charger.setInsID(ins_ID);
            charger.setLossAmountHuman(lossAmountHuman);
            charger.setLossAmountProperty(lossAmountProperty);
            charger.setDecisionCompensationProperty(decisionCompensationProperty);
            charger.setDecisionCompensationHuman(decisionCompensationHuman);
            charger.setCustID(cust_ID);
            charger.setDocID(doc_ID);
            charger.setDate(date);
            charger.setPaymentReportOK(paymentReportOK);
            charger.setPaymentCompleted(paymentCompleted);

            updateCharger = chargerRepository.save(charger);
        }else {
            throw new Exception();
        }
         return updateCharger;
    }

    @Override
    public void deleteCharger(int accident_NM) throws Exception {
    Optional<Charger> selectedCharger = chargerRepository.findById(accident_NM);

    if(selectedCharger.isPresent()){
        Charger charger = selectedCharger.get();
        chargerRepository.delete(charger);
    } else {
        throw new Exception();
    }
    }
}
