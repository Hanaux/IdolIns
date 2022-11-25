package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.AccidentDao;
import com.mju.IdolIns.data.entity.Accident;
import com.mju.IdolIns.data.repository.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class AccidentDaoImpl implements AccidentDao {
    private final AccidentRepository accidentRepository;

    @Autowired
    public AccidentDaoImpl(AccidentRepository accidentRepository){
        this.accidentRepository = accidentRepository;
    }
    @Override
    public Accident insertAccident(Accident accident) {
        Accident savedAccident = accidentRepository.save(accident);
        return savedAccident;
    }

    @Override
    public Accident selectAccident(int accident_NM) {
        Accident selectedAccident = accidentRepository.getById(accident_NM);
        return selectedAccident;
    }

    @Override
    public Accident updateAccident(int accident_NM, String name, String dateOfBirth,
                                   int sex, String acc_Detail, String acc_Spot, String phoneNum) throws Exception {
        Optional<Accident> selectedAccident = accidentRepository.findById(accident_NM);
        Accident updateAccident;

        if(selectedAccident.isPresent()){
            Accident accident = selectedAccident.get();

            accident.setName(name);
            accident.setDateOfBirth(dateOfBirth);
            accident.setSex(sex);
            accident.setAccidentDetail(acc_Detail);
            accident.setAccidentSpot(acc_Spot);
            accident.setPhoneNum(phoneNum);

            updateAccident = accidentRepository.save(accident);
        } else{
            throw new Exception();
        }
        return updateAccident;
    }

    @Override
    public void deleteAccident(int accident_NM) throws Exception {
        Optional<Accident> selectedAccident = accidentRepository.findById(accident_NM);

        if(selectedAccident.isPresent()){
            Accident accident = selectedAccident.get();
            accidentRepository.delete(accident);
        } else {
            throw new Exception();
        }
    }
}
