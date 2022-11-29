package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.AccidentHandlerDao;
import com.mju.IdolIns.data.entity.AccidentHandler;
import com.mju.IdolIns.data.repository.AccidentHandlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccidentHandlerDaoImpl implements AccidentHandlerDao {
    private final AccidentHandlerRepository accidentHandlerRepository;

    @Autowired
    public AccidentHandlerDaoImpl(AccidentHandlerRepository accidentHandlerRepository) {this.accidentHandlerRepository = accidentHandlerRepository;}

    @Override
    public AccidentHandler insertAccidentHandler(AccidentHandler accidentHandler) {
        AccidentHandler savedAccidentHandler = accidentHandlerRepository.save(accidentHandler);
        return savedAccidentHandler;
    }

    @Override
    public AccidentHandler selectAccidentHandler(int accident_NM) {
        AccidentHandler selectedAccidentHandler = accidentHandlerRepository.getById(accident_NM);
        return selectedAccidentHandler;
    }

    @Override
    public AccidentHandler updateAccidentHandler(int accident_NM, String accident_Spot, String accident_Detail,
                                                 int cust_ID, int ins_ID, int indemnification, int damage_Amount) throws Exception {
        Optional<AccidentHandler> selectedAccidentHandler = accidentHandlerRepository.findById(accident_NM);

        AccidentHandler updateAccidentHandler;

        if(selectedAccidentHandler.isPresent()){

            AccidentHandler accidentHandler = selectedAccidentHandler.get();

            accidentHandler.setAccidentSpot(accident_Spot);
            accidentHandler.setAccidentDetail(accident_Detail);
            accidentHandler.setCustId(cust_ID);
            accidentHandler.setInsId(ins_ID);
            accidentHandler.setIndemnification(indemnification);
            accidentHandler.setDamageAmount(damage_Amount);

            updateAccidentHandler = accidentHandlerRepository.save(accidentHandler);
        }else{
            throw new Exception();
        }
        return updateAccidentHandler;
    }

    @Override
    public void deleteAccidentHandler(int accident_NM) throws Exception {
        Optional<AccidentHandler> selectedAccidentHandler = accidentHandlerRepository.findById(accident_NM);

        if(selectedAccidentHandler.isPresent()){
            AccidentHandler accidentHandler = selectedAccidentHandler.get();
            accidentHandlerRepository.delete(accidentHandler);
        } else{
            throw new Exception();
        }

    }
}
