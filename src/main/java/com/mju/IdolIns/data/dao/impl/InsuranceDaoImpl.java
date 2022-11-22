package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.InsuranceDao;
import com.mju.IdolIns.data.entity.Insurance;
import com.mju.IdolIns.data.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InsuranceDaoImpl implements InsuranceDao {

    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceDaoImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public Insurance insertInsurance(Insurance insurance) {
        Insurance savedInsurance = insuranceRepository.save(insurance);
        return savedInsurance;
    }

    @Override
    public Insurance selectInsurance(int insId) {
        Insurance selectedInsurance = insuranceRepository.getById(insId);
        return selectedInsurance;
    }

    @Override
    public Insurance updateInsuranceName(int insId, String insName) throws Exception {
        Optional<Insurance> selectedInsurance = insuranceRepository.findById(insId);

        Insurance updatedInsurance;
        if(selectedInsurance.isPresent()) {
            Insurance insurance = selectedInsurance.get();

            insurance.setInsName(insName);

            updatedInsurance = insuranceRepository.save(insurance);
        }else {
            throw new Exception();
        }
        return updatedInsurance;
    }

    @Override
    public void deleteInsurance(int insId) throws Exception {
        Optional<Insurance> selectedInsurance = insuranceRepository.findById(insId);

        if(selectedInsurance.isPresent()){
            Insurance insurance = selectedInsurance.get();
            insuranceRepository.delete(insurance);
        } else {
            throw new Exception();
        }
    }
}