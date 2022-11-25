package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.CalculationDao;
import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.entity.Calculation;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.repository.CalculationRepository;
import com.mju.IdolIns.data.repository.ChargerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CalculationDaoImpl implements CalculationDao {

    private final CalculationRepository calculationRepository;

    @Autowired
    public CalculationDaoImpl(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    @Override
    public Calculation insertCalculation(Calculation calculation) {
        Calculation savedCalculation = calculationRepository.save(calculation);
        return savedCalculation;
    }

    @Override
    public Calculation selectCalculation(int accident_NM) {
        Calculation selectedCalculation = calculationRepository.getById(accident_NM);
        return selectedCalculation;
    }

    @Override
    public Calculation updateCalculationInfo(int accident_NM, int decisionCompensationProperty, int decisionCompensationHuman) throws Exception {
        Optional<Calculation> selectedCalculation = calculationRepository.findById(accident_NM);

        Calculation updateCalculation;
        if(selectedCalculation.isPresent()) {
            Calculation calculation = selectedCalculation.get();

            calculation.setDecisionCompensationProperty(decisionCompensationProperty);
            calculation.setDecisionCompensationHuman(decisionCompensationHuman);
//            charger.setCustID(cust_ID);
//            charger.setDocID(doc_ID);
//            charger.setDate(date);
//            charger.setPaymentReportOK(paymentReportOK);
//            charger.setPaymentCompleted(paymentCompleted);

            updateCalculation = calculationRepository.save(calculation);
        }else {
            throw new Exception();
        }
         return updateCalculation;
    }

    @Override
    public void deleteCalculation(int accident_NM) throws Exception {
    Optional<Calculation> selectedCalculation = calculationRepository.findById(accident_NM);

    if(selectedCalculation.isPresent()){
        Calculation calculation = selectedCalculation.get();
        calculationRepository.delete(calculation);
    } else {
        throw new Exception();
    }
    }
}
