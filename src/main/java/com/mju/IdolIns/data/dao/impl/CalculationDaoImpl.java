package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.CalculationDao;
import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.entity.Calculation;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.data.repository.CalculationRepository;
import com.mju.IdolIns.data.repository.ChargerRepository;
import com.mju.IdolIns.exception.CustomException;
import com.mju.IdolIns.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class CalculationDaoImpl implements CalculationDao {

    private final CalculationRepository calculationRepository;

    @Autowired
    public CalculationDaoImpl(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    @Override
    public Calculation insertCalculation(Calculation calculation) throws CustomException {
        Calculation savedCalculation = Optional.of(calculationRepository.save(calculation))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedCalculation;
    }

    @Override
    public Calculation selectCalculation(int docID) throws CustomException {
        Calculation selectedCalculation = Optional.of(calculationRepository.getById(docID))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        return selectedCalculation;
    }

    @Override
    public Calculation updateCalculationInfo(int docID, int accident_NM, int decisionCompensationProperty, int decisionCompensationHuman) throws CustomException{
        Optional<Calculation> selectedCalculation = Optional.ofNullable(calculationRepository.findById(docID))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Calculation updateCalculation;
            Calculation calculation = selectedCalculation.get();

            calculation.setAccNum(accident_NM);
            calculation.setDecisionCompensationProperty(decisionCompensationProperty);
            calculation.setDecisionCompensationHuman(decisionCompensationHuman);

            updateCalculation = Optional.of(calculationRepository.save(calculation))
                    .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));

         return updateCalculation;
    }

    @Override
    public void deleteCalculation(int docID) throws CustomException{
    Optional<Calculation> selectedCalculation = Optional.ofNullable(calculationRepository.findById(docID))
            .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Calculation calculation = selectedCalculation.get();
        try {
            calculationRepository.delete(calculation);
        } catch (CustomException e){
            e = new CustomException(COULD_NOT_DELETE);
        }


    }
}
