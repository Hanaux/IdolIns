package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.CalculationDao;
import com.mju.IdolIns.data.dao.ChargerDao;
import com.mju.IdolIns.data.dto.calculationdto.CalculationDto;
import com.mju.IdolIns.data.dto.calculationdto.CalculationResponseDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerResponseDto;
import com.mju.IdolIns.data.entity.Calculation;
import com.mju.IdolIns.data.entity.Charger;
import com.mju.IdolIns.service.CalculationService;
import com.mju.IdolIns.service.ChargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    private final CalculationDao calculationDao;

    @Autowired
    public CalculationServiceImpl(CalculationDao calculationDao){
        this.calculationDao = calculationDao;
    }

    @Override
    public CalculationResponseDto getCalculation(int accident_NM) {
        Calculation calculation = calculationDao.selectCalculation(accident_NM);

        CalculationResponseDto calculationResponseDto = new CalculationResponseDto();

        calculationResponseDto.setAccident_NM(calculation.getAccNum());
        calculationResponseDto.setDecisionCompensationProperty(calculation.getDecisionCompensationProperty());
        calculationResponseDto.setDecisionCompensationHuman(calculation.getDecisionCompensationHuman());

        return calculationResponseDto;
    }

    @Override
    public CalculationResponseDto saveCalculation(CalculationDto calculationDto) {
        Calculation calculation = new Calculation();
        calculation.setDecisionCompensationProperty(calculationDto.getDecisionCompensationProperty());
        calculation.setDecisionCompensationHuman(calculationDto.getDecisionCompensationHuman());

        Calculation savedCalculation = calculationDao.insertCalculation(calculation);

        CalculationResponseDto calculationResponseDto = new CalculationResponseDto();

        calculationResponseDto.setAccident_NM(savedCalculation.getAccNum());
        calculationResponseDto.setDecisionCompensationProperty(savedCalculation.getDecisionCompensationProperty());
        calculationResponseDto.setDecisionCompensationHuman(savedCalculation.getDecisionCompensationHuman());

        return calculationResponseDto;
    }

    @Override
    public CalculationResponseDto changeCalculationInfo(int accident_NM, int decisionCompensationProperty, int decisionCompensationHuman) throws Exception {
        Calculation changedCalculation = calculationDao.updateCalculationInfo(accident_NM, decisionCompensationProperty, decisionCompensationHuman);

        CalculationResponseDto calculationResponseDto = new CalculationResponseDto();

        calculationResponseDto.setAccident_NM(changedCalculation.getAccNum());
        calculationResponseDto.setDecisionCompensationProperty(changedCalculation.getDecisionCompensationProperty());
        calculationResponseDto.setDecisionCompensationHuman(changedCalculation.getDecisionCompensationHuman());

        return calculationResponseDto;
    }

    @Override
    public void deleteCalculation(int accident_NM) throws Exception {
        calculationDao.deleteCalculation(accident_NM);
    }
}
