package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.service.InsuranceCenterService;
import com.mju.IdolIns.data.dao.InsuranceCenterDao;
import com.mju.IdolIns.data.dto.insurancecenterdto.InsuranceCenterDto;
import com.mju.IdolIns.data.dto.insurancecenterdto.InsuranceCenterResponseDto;
import com.mju.IdolIns.data.entity.InsuranceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InsuranceCenterServiceImpl implements InsuranceCenterService {
    private final InsuranceCenterDao insuranceCenterDao;

    @Autowired
    public InsuranceCenterServiceImpl(InsuranceCenterDao insuranceCenterDao){this.insuranceCenterDao = insuranceCenterDao;}

    @Override
    public InsuranceCenterResponseDto getInsuranceCenter(int centerNum) {
        InsuranceCenter insuranceCenter = insuranceCenterDao.selectInsuranceCenter(centerNum);

        InsuranceCenterResponseDto centerResponseDto = new InsuranceCenterResponseDto();

        centerResponseDto.setCenterNum(insuranceCenter.getCenterNum());
        centerResponseDto.setCenterName(insuranceCenter.getCenterName());
        centerResponseDto.setCenterLocation(insuranceCenter.getCenterLocation());
        centerResponseDto.setCenterAddress(insuranceCenter.getCenterAddress());

        return centerResponseDto;
    }

    @Override
    public InsuranceCenterResponseDto saveInsuranceCenter(InsuranceCenterDto insuranceCenterDto) {
        InsuranceCenter insuranceCenter = new InsuranceCenter();
        insuranceCenter.setCenterName(insuranceCenterDto.getCenterName());
        insuranceCenter.setCenterLocation(insuranceCenterDto.getCenterLocation());
        insuranceCenter.setCenterAddress(insuranceCenterDto.getCenterAddress());

        InsuranceCenter savedCenter = insuranceCenterDao.insertInsuranceCenter(insuranceCenter);

        InsuranceCenterResponseDto insuranceCenterResponseDto = new InsuranceCenterResponseDto();

        insuranceCenterResponseDto.setCenterNum(savedCenter.getCenterNum());
        insuranceCenterResponseDto.setCenterName(savedCenter.getCenterName());
        insuranceCenterResponseDto.setCenterLocation(savedCenter.getCenterLocation());
        insuranceCenterResponseDto.setCenterAddress(savedCenter.getCenterAddress());

        return insuranceCenterResponseDto;
    }

    @Override
    public InsuranceCenterResponseDto changeInsuranceCenterInfo(int centerNum, String centerName,
                                                                String centerLocation, String centerAddress) throws Exception {
        InsuranceCenter changedCenter = insuranceCenterDao.updateInsuranceCenter(centerNum, centerName, centerLocation, centerAddress);

        InsuranceCenterResponseDto insuranceCenterResponseDto = new InsuranceCenterResponseDto();
        insuranceCenterResponseDto.setCenterNum(changedCenter.getCenterNum());
        insuranceCenterResponseDto.setCenterName(changedCenter.getCenterName());
        insuranceCenterResponseDto.setCenterLocation(changedCenter.getCenterLocation());
        insuranceCenterResponseDto.setCenterAddress(changedCenter.getCenterAddress());
        return insuranceCenterResponseDto;
    }

    @Override
    public void deleteInsuranceCenter(int centerNum) throws Exception {
        insuranceCenterDao.deleteInsuranceCenter(centerNum);
    }
}
