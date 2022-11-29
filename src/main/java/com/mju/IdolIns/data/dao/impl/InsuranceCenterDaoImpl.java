package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.InsuranceCenterDao;
import com.mju.IdolIns.data.entity.InsuranceCenter;
import com.mju.IdolIns.data.repository.InsuranceCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InsuranceCenterDaoImpl implements InsuranceCenterDao {
    private final InsuranceCenterRepository insuranceCenterRepository;

    @Autowired
    public InsuranceCenterDaoImpl(InsuranceCenterRepository insuranceCenterRepository){
        this.insuranceCenterRepository = insuranceCenterRepository;
    }
    @Override
    public InsuranceCenter insertInsuranceCenter(InsuranceCenter insuranceCenter) {
        InsuranceCenter savedCenter = insuranceCenterRepository.save(insuranceCenter);
        return savedCenter;
    }

    @Override
    public InsuranceCenter selectInsuranceCenter(int centerNum) {
        InsuranceCenter selectedCenter = insuranceCenterRepository.getById(centerNum);
        return selectedCenter;
    }

    @Override
    public InsuranceCenter updateInsuranceCenter(int centerNum, String centerName, String centerLocation, String centerAddress, String centerHotline) throws Exception {
        Optional<InsuranceCenter> selectedCenter = insuranceCenterRepository.findById(centerNum);
        InsuranceCenter updateCenter;

        if(selectedCenter.isPresent()){
            InsuranceCenter center = selectedCenter.get();
            center.setCenterName(centerName);
            center.setCenterLocation(centerLocation);
            center.setCenterAddress(centerAddress);
            center.setCenterHotline(centerHotline);

            updateCenter = insuranceCenterRepository.save(center);
        }else{
            throw new Exception();
        }
        return updateCenter;
    }

    @Override
    public List<InsuranceCenter> getAllInsuranceCenter(){
        List<InsuranceCenter> centerList;
        centerList = insuranceCenterRepository.findAll();

        return centerList;
    }

    @Override
    public void deleteInsuranceCenter(int centerNum) throws Exception {
        Optional<InsuranceCenter> selectedCenter = insuranceCenterRepository.findById(centerNum);

        if(selectedCenter.isPresent()){
            InsuranceCenter insuranceCenter = selectedCenter.get();
            insuranceCenterRepository.delete(insuranceCenter);
        } else {
            throw new Exception();
        }
    }
}
