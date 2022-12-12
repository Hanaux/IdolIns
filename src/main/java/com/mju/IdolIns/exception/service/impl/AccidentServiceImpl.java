package com.mju.IdolIns.exception.service.impl;

import com.mju.IdolIns.data.dao.AccidentDao;
import com.mju.IdolIns.data.dto.accidentdto.AccidentDto;
import com.mju.IdolIns.data.dto.accidentdto.AccidentResponseDto;
import com.mju.IdolIns.data.entity.Accident;
import com.mju.IdolIns.exception.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccidentServiceImpl implements AccidentService {
    private final AccidentDao accidentDao;

    @Autowired
    public AccidentServiceImpl(AccidentDao accidentDao){
        this.accidentDao = accidentDao;
    }

    @Override
    public AccidentResponseDto getAccident(int accident_NM) {
        Accident accident = accidentDao.selectAccident(accident_NM);

        AccidentResponseDto accidentResponseDto = new AccidentResponseDto();

        accidentResponseDto.setAccident_NM(accident.getAccNum());
        accidentResponseDto.setName(accident.getName());
        accidentResponseDto.setDateOfBirth(accident.getDateOfBirth());
        accidentResponseDto.setSex(accident.getSex());
        accidentResponseDto.setAccidentDetail(accident.getAccidentDetail());
        accidentResponseDto.setAccidentSpot(accident.getAccidentSpot());
        accidentResponseDto.setPhone_NM(accident.getPhoneNum());

        return accidentResponseDto;
    }

    @Override
    public AccidentResponseDto saveAccident(AccidentDto accidentDto) {
        Accident accident = new Accident();
        accident.setName(accidentDto.getName());
        accident.setDateOfBirth(accidentDto.getDateOfBirth());
        accident.setSex(accidentDto.getSex());
        accident.setAccidentDetail(accidentDto.getAccidentDetail());
        accident.setAccidentSpot(accidentDto.getAccidentSpot());
        accident.setPhoneNum(accidentDto.getPhoneNum());

        Accident savedAccident = accidentDao.insertAccident(accident);

        AccidentResponseDto accidentResponseDto = new AccidentResponseDto();

        accidentResponseDto.setAccident_NM(savedAccident.getAccNum());
        accidentResponseDto.setName(savedAccident.getName());
        accidentResponseDto.setDateOfBirth(savedAccident.getDateOfBirth());
        accidentResponseDto.setSex(savedAccident.getSex());
        accidentResponseDto.setAccidentDetail(savedAccident.getAccidentDetail());
        accidentResponseDto.setAccidentSpot(savedAccident.getAccidentSpot());
        accidentResponseDto.setPhone_NM(savedAccident.getPhoneNum());

        return accidentResponseDto;
    }

    @Override
    public AccidentResponseDto changeAccidentInfo(int accident_NM, String name, String dateOfBirth,
                                                  int sex, String accidentDetail, String accidentSpot, String phoneNum) throws Exception {
        Accident changedAccident = accidentDao.updateAccident(accident_NM, name, dateOfBirth,
                sex, accidentDetail, accidentSpot, phoneNum);

        AccidentResponseDto accidentResponseDto = new AccidentResponseDto();
        accidentResponseDto.setAccident_NM(accident_NM);
        accidentResponseDto.setName(name);
        accidentResponseDto.setDateOfBirth(dateOfBirth);
        accidentResponseDto.setSex(sex);
        accidentResponseDto.setAccidentDetail(accidentDetail);
        accidentResponseDto.setAccidentSpot(accidentSpot);
        accidentResponseDto.setPhone_NM(phoneNum);

        return accidentResponseDto;
    }

    @Override
    public void deleteAccident(int accident_NM) throws Exception {
        accidentDao.deleteAccident(accident_NM);
    }
}
