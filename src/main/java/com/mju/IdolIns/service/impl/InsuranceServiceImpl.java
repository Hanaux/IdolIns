package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.InsuranceDao;
import com.mju.IdolIns.data.dto.insurancedto.InsuranceDto;
import com.mju.IdolIns.data.dto.insurancedto.InsuranceResponseDto;
import com.mju.IdolIns.data.entity.Insurance;
import com.mju.IdolIns.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceDao insuranceDAO;

    @Autowired
    public InsuranceServiceImpl(InsuranceDao insuranceDao){
        this.insuranceDAO = insuranceDao;
    }
    @Override
    public InsuranceResponseDto getInsurance(int ins_ID) {
        Insurance insurance = insuranceDAO.selectInsurance(ins_ID);

        InsuranceResponseDto insuranceResponseDto = new InsuranceResponseDto();

        insuranceResponseDto.setIns_ID(insurance.getInsId());
        insuranceResponseDto.setIns_NM(insurance.getInsName());
        insuranceResponseDto.setDepartment(insurance.getDepartment());
        insuranceResponseDto.setTarget_Cust(insurance.getTarget_Cust());
        insuranceResponseDto.setDetail(insurance.getDetail());
        insuranceResponseDto.setInsFee(insurance.getInsFee());
        insuranceResponseDto.setRate(insurance.getRate());
        insuranceResponseDto.setCompensation(insurance.getCompensation());
        insuranceResponseDto.setPermission(insurance.getPermission());

        return insuranceResponseDto;
    }

    @Override
    public InsuranceResponseDto saveInsurance(InsuranceDto insuranceDto) {
        Insurance insurance = new Insurance();
        insurance.setInsName(insuranceDto.getIns_NM());
        insurance.setDepartment(insuranceDto.getDepartment());
        insurance.setTarget_Cust(insuranceDto.getTarget_Cust());
        insurance.setDetail(insuranceDto.getDetail());
        insurance.setInsFee(insuranceDto.getInsFee());
        insurance.setRate(insuranceDto.getRate());
        insurance.setCompensation(insuranceDto.getCompensation());
        insurance.setPermission(insuranceDto.getPermission());

        Insurance savedInsurance = insuranceDAO.insertInsurance(insurance);

        InsuranceResponseDto insuranceResponseDto = new InsuranceResponseDto();

        insuranceResponseDto.setIns_ID(savedInsurance.getInsId());
        insuranceResponseDto.setIns_NM(savedInsurance.getInsName());
        insuranceResponseDto.setDepartment(savedInsurance.getDepartment());
        insuranceResponseDto.setTarget_Cust(savedInsurance.getTarget_Cust());
        insuranceResponseDto.setDetail(savedInsurance.getDetail());
        insuranceResponseDto.setInsFee(savedInsurance.getInsFee());
        insuranceResponseDto.setRate(savedInsurance.getRate());
        insuranceResponseDto.setCompensation(savedInsurance.getCompensation());
        insuranceResponseDto.setPermission(savedInsurance.getPermission());

        return insuranceResponseDto;
    }

    @Override
    public InsuranceResponseDto changeInsuranceName(int ins_ID, String ins_NM) throws Exception {
        Insurance changedInsurance = insuranceDAO.updateInsuranceName(ins_ID, ins_NM);

        InsuranceResponseDto insuranceResponseDto = new InsuranceResponseDto();

        insuranceResponseDto.setIns_ID(changedInsurance.getInsId());
        insuranceResponseDto.setIns_NM(changedInsurance.getInsName());
        insuranceResponseDto.setDepartment(changedInsurance.getDepartment());
        insuranceResponseDto.setTarget_Cust(changedInsurance.getTarget_Cust());
        insuranceResponseDto.setDetail(changedInsurance.getDetail());
        insuranceResponseDto.setInsFee(changedInsurance.getInsFee());
        insuranceResponseDto.setRate(changedInsurance.getRate());
        insuranceResponseDto.setCompensation(changedInsurance.getCompensation());
        insuranceResponseDto.setPermission(changedInsurance.getPermission());

        return insuranceResponseDto;
    }

    @Override
    public void deleteInsurance(int ins_ID) throws Exception {
        insuranceDAO.deleteInsurance(ins_ID);
    }
}
