package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.InsuranceCenterDao;
import com.mju.IdolIns.data.entity.InsuranceCenter;
import com.mju.IdolIns.data.repository.InsuranceCenterRepository;
import com.mju.IdolIns.exception.CustomException;
import com.mju.IdolIns.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class InsuranceCenterDaoImpl implements InsuranceCenterDao {
    private final InsuranceCenterRepository insuranceCenterRepository;

    @Autowired
    public InsuranceCenterDaoImpl(InsuranceCenterRepository insuranceCenterRepository){
        this.insuranceCenterRepository = insuranceCenterRepository;
    }
    @Override
    public InsuranceCenter insertInsuranceCenter(InsuranceCenter insuranceCenter) throws CustomException {
        InsuranceCenter savedCenter = Optional.of(insuranceCenterRepository.save(insuranceCenter))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedCenter;
    }

    @Override
    public InsuranceCenter selectInsuranceCenter(int centerNum) throws CustomException{
        InsuranceCenter selectedCenter = Optional.of(insuranceCenterRepository.getById(centerNum))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        return selectedCenter;
    }

    @Override
    public InsuranceCenter updateInsuranceCenter(int centerNum, String centerName, String centerLocation, String centerAddress, String centerHotline) throws CustomException {
        Optional<InsuranceCenter> selectedCenter = Optional.ofNullable(insuranceCenterRepository.findById(centerNum))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        InsuranceCenter updateCenter;

            InsuranceCenter center = selectedCenter.get();
            center.setCenterName(centerName);
            center.setCenterLocation(centerLocation);
            center.setCenterAddress(centerAddress);
            center.setCenterHotline(centerHotline);

            updateCenter = Optional.of(insuranceCenterRepository.save(center))
                    .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));

        return updateCenter;
    }

    @Override
    public List<InsuranceCenter> getAllInsuranceCenter() throws CustomException{
        List<InsuranceCenter> centerList;
        centerList = Optional.of(insuranceCenterRepository.findAll())
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        return centerList;
    }

    @Override
    public void deleteInsuranceCenter(int centerNum) throws CustomException {
        Optional<InsuranceCenter> selectedCenter = Optional.ofNullable(insuranceCenterRepository.findById(centerNum))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

            InsuranceCenter insuranceCenter = selectedCenter.get();
            try {
                insuranceCenterRepository.delete(insuranceCenter);
            } catch (CustomException e){
                e = new CustomException(COULD_NOT_DELETE);
            }


    }
}
