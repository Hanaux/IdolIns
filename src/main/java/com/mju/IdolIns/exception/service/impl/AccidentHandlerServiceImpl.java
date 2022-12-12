package com.mju.IdolIns.exception.service.impl;

import com.mju.IdolIns.data.dao.AccidentHandlerDao;
import com.mju.IdolIns.data.dto.accidenthandlerdto.AccidentHandlerDto;
import com.mju.IdolIns.data.dto.accidenthandlerdto.AccidentHandlerResponseDto;
import com.mju.IdolIns.data.entity.AccidentHandler;
import com.mju.IdolIns.exception.service.AccidentHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccidentHandlerServiceImpl implements AccidentHandlerService {

    private final AccidentHandlerDao accidentHandlerDao;

    @Autowired
    public AccidentHandlerServiceImpl(AccidentHandlerDao accidentHandlerDao){this.accidentHandlerDao = accidentHandlerDao;}

    @Override
    public AccidentHandlerResponseDto getAccidentHandler(int accident_NM) {
        AccidentHandler accidentHandler = accidentHandlerDao.selectAccidentHandler(accident_NM);

        AccidentHandlerResponseDto accidentHandlerResponseDto = new AccidentHandlerResponseDto();

        accidentHandlerResponseDto.setAccident_NM(accidentHandler.getAccNum());
        accidentHandlerResponseDto.setAccident_Spot(accidentHandler.getAccidentSpot());
        accidentHandlerResponseDto.setAccident_Detail(accidentHandler.getAccidentDetail());
        accidentHandlerResponseDto.setCust_ID(accidentHandler.getCustId());
        accidentHandlerResponseDto.setIns_ID(accidentHandler.getInsId());
        accidentHandlerResponseDto.setIndemnification(accidentHandler.getIndemnification());
        accidentHandlerResponseDto.setDamage_Amount(accidentHandler.getDamageAmount());

        return accidentHandlerResponseDto;
    }

    @Override
    public AccidentHandlerResponseDto saveAccidentHandler(AccidentHandlerDto accidentHandlerDto) {
        AccidentHandler accidentHandler = new AccidentHandler();
        accidentHandler.setAccidentSpot(accidentHandlerDto.getAccident_Spot());
        accidentHandler.setAccidentDetail(accidentHandlerDto.getAccident_Detail());
        accidentHandler.setCustId(accidentHandlerDto.getCust_ID());
        accidentHandler.setInsId(accidentHandlerDto.getIns_ID());
        accidentHandler.setIndemnification(accidentHandlerDto.getIndemnification());
        accidentHandler.setDamageAmount(accidentHandlerDto.getDamage_Amount());

        AccidentHandler savedAccidentHandler = accidentHandlerDao.insertAccidentHandler(accidentHandler);

        AccidentHandlerResponseDto accidentHandlerResponseDto = new AccidentHandlerResponseDto();

        accidentHandlerResponseDto.setAccident_NM(savedAccidentHandler.getAccNum());
        accidentHandlerResponseDto.setAccident_Spot(savedAccidentHandler.getAccidentSpot());
        accidentHandlerResponseDto.setAccident_Detail(savedAccidentHandler.getAccidentDetail());
        accidentHandlerResponseDto.setCust_ID(savedAccidentHandler.getCustId());
        accidentHandlerResponseDto.setIns_ID(savedAccidentHandler.getInsId());
        accidentHandlerResponseDto.setIndemnification(savedAccidentHandler.getIndemnification());
        accidentHandlerResponseDto.setDamage_Amount(savedAccidentHandler.getDamageAmount());

        return accidentHandlerResponseDto;
    }

    @Override
    public AccidentHandlerResponseDto changeAccidentHandlerInfo(int accident_NM, String accident_Spot, String accident_Detail, int cust_ID,
                                                                int ins_ID, int indemnification, int damage_Amount) throws Exception {
        AccidentHandler changedAccidentHandler = accidentHandlerDao.updateAccidentHandler(accident_NM, accident_Spot, accident_Detail,
                cust_ID, ins_ID, indemnification, damage_Amount);

        AccidentHandlerResponseDto accidentHandlerResponseDto = new AccidentHandlerResponseDto();
        accidentHandlerResponseDto.setAccident_NM(changedAccidentHandler.getAccNum());
        accidentHandlerResponseDto.setAccident_Spot(changedAccidentHandler.getAccidentSpot());
        accidentHandlerResponseDto.setAccident_Detail(changedAccidentHandler.getAccidentDetail());
        accidentHandlerResponseDto.setCust_ID(changedAccidentHandler.getCustId());
        accidentHandlerResponseDto.setIns_ID(changedAccidentHandler.getInsId());
        accidentHandlerResponseDto.setIndemnification(changedAccidentHandler.getIndemnification());
        accidentHandlerResponseDto.setDamage_Amount(changedAccidentHandler.getDamageAmount());

        return accidentHandlerResponseDto;
    }

    @Override
    public void deleteAccidentHandler(int accident_NM) throws Exception {
        accidentHandlerDao.deleteAccidentHandler(accident_NM);
    }
}
