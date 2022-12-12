package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.InsuranceDao;
import com.mju.IdolIns.data.entity.Insurance;
import com.mju.IdolIns.data.repository.InsuranceRepository;
import com.mju.IdolIns.exception.CustomException;
import com.mju.IdolIns.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class InsuranceDaoImpl implements InsuranceDao {

    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceDaoImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public Insurance insertInsurance(Insurance insurance) throws CustomException{
        Insurance savedInsurance = Optional.of(insuranceRepository.save(insurance))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedInsurance;
    }

    @Override
    public Insurance selectInsurance(int insId) throws CustomException {
        Insurance selectedInsurance = Optional.of(insuranceRepository.getById(insId))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        return selectedInsurance;
    }

    @Override
    public Insurance updateInsuranceName(int insId, String insName) throws CustomException {
        Optional<Insurance> selectedInsurance = Optional.ofNullable(insuranceRepository.findById(insId))
                .orElseThrow(() -> new CustomException(DATA_NOT_FOUND));

            Insurance updatedInsurance;
            Insurance insurance = selectedInsurance.get();

            insurance.setInsName(insName);

            updatedInsurance = Optional.of(insuranceRepository.save(insurance))
                    .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));

         return updatedInsurance;
    }

    @Override
    public void deleteInsurance(int insId) throws CustomException {
    Optional<Insurance> selectedInsurance = Optional.ofNullable(insuranceRepository.findById(insId))
            .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        Insurance deletedInsurance;
        Insurance insurance = selectedInsurance.get();
        try{
        insuranceRepository.delete(insurance);
        }catch(CustomException e){
            e = new CustomException(COULD_NOT_DELETE);
        }
    }

    @Override
    public Insurance updateInsurancePermission(int insId, int permission) throws CustomException {
        Optional<Insurance> selectedInsurance = Optional.ofNullable(insuranceRepository.findById(insId))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Insurance updatedInsurance;
            Insurance insurance = selectedInsurance.get();

            insurance.setPermission(permission);

            updatedInsurance = Optional.of(insuranceRepository.save(insurance))
                    .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));

        return updatedInsurance;
    }
}
