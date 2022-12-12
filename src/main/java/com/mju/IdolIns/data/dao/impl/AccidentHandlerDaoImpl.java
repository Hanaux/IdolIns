package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.AccidentHandlerDao;
import com.mju.IdolIns.data.entity.AccidentHandler;
import com.mju.IdolIns.data.repository.AccidentHandlerRepository;
import com.mju.IdolIns.exception.CustomException;
import com.mju.IdolIns.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class AccidentHandlerDaoImpl implements AccidentHandlerDao {
    private final AccidentHandlerRepository accidentHandlerRepository;

    @Autowired
    public AccidentHandlerDaoImpl(AccidentHandlerRepository accidentHandlerRepository) {this.accidentHandlerRepository = accidentHandlerRepository;}

    @Override
    public AccidentHandler insertAccidentHandler(AccidentHandler accidentHandler) throws CustomException {
        AccidentHandler savedAccidentHandler = Optional.of(accidentHandlerRepository.save(accidentHandler))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedAccidentHandler;
    }

    @Override
    public AccidentHandler selectAccidentHandler(int accident_NM) throws CustomException{
        AccidentHandler selectedAccidentHandler = Optional.of(accidentHandlerRepository.getById(accident_NM))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        return selectedAccidentHandler;
    }

    @Override
    public AccidentHandler updateAccidentHandler(int accident_NM, String accident_Spot, String accident_Detail,
                                                 int cust_ID, int ins_ID, int indemnification, int damage_Amount) throws CustomException {
        Optional<AccidentHandler> selectedAccidentHandler = Optional.ofNullable(accidentHandlerRepository.findById(accident_NM))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        AccidentHandler updateAccidentHandler;

            AccidentHandler accidentHandler = selectedAccidentHandler.get();

            accidentHandler.setAccidentSpot(accident_Spot);
            accidentHandler.setAccidentDetail(accident_Detail);
            accidentHandler.setCustId(cust_ID);
            accidentHandler.setInsId(ins_ID);
            accidentHandler.setIndemnification(indemnification);
            accidentHandler.setDamageAmount(damage_Amount);

            updateAccidentHandler = Optional.of(accidentHandlerRepository.save(accidentHandler))
                    .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));

        return updateAccidentHandler;
    }

    @Override
    public void deleteAccidentHandler(int accident_NM) throws CustomException {
        Optional<AccidentHandler> selectedAccidentHandler = Optional.ofNullable(accidentHandlerRepository.findById(accident_NM))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

            AccidentHandler accidentHandler = selectedAccidentHandler.get();
            try {
                accidentHandlerRepository.delete(accidentHandler);
            }catch (CustomException e){
                e = new CustomException(COULD_NOT_DELETE);
            }



    }
}
