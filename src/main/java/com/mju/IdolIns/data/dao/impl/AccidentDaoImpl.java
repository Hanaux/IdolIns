package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.AccidentDao;
import com.mju.IdolIns.data.entity.Accident;
import com.mju.IdolIns.data.repository.AccidentRepository;
import com.mju.IdolIns.exception.CustomException;
import com.mju.IdolIns.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class AccidentDaoImpl implements AccidentDao {
    private final AccidentRepository accidentRepository;

    @Autowired
    public AccidentDaoImpl(AccidentRepository accidentRepository){
        this.accidentRepository = accidentRepository;
    }
    @Override
    public Accident insertAccident(Accident accident) throws CustomException {
        Accident savedAccident = Optional.of(accidentRepository.save(accident))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedAccident;
    }

    @Override
    public Accident selectAccident(int accident_NM) throws CustomException{
        Accident selectedAccident = Optional.of(accidentRepository.getById(accident_NM))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));
        return selectedAccident;
    }

    @Override
    public Accident updateAccident(int accident_NM, String name, String dateOfBirth,
                                   int sex, String acc_Detail, String acc_Spot, String phoneNum) throws CustomException {
        Optional<Accident> selectedAccident = Optional.ofNullable(accidentRepository.findById(accident_NM))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

            Accident updateAccident;
            Accident accident = selectedAccident.get();

            accident.setName(name);
            accident.setDateOfBirth(dateOfBirth);
            accident.setSex(sex);
            accident.setAccidentDetail(acc_Detail);
            accident.setAccidentSpot(acc_Spot);
            accident.setPhoneNum(phoneNum);

            updateAccident = Optional.of(accidentRepository.save(accident))
                    .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));

        return updateAccident;
    }

    @Override
    public void deleteAccident(int accident_NM) throws CustomException {
        Optional<Accident> selectedAccident = Optional.ofNullable(accidentRepository.findById(accident_NM))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

            Accident accident = selectedAccident.get();
            try{
                accidentRepository.delete(accident);
            }catch(CustomException e){
                e = new CustomException(COULD_NOT_DELETE);
            }


    }
}
