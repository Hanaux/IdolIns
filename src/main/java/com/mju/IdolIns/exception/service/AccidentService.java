package com.mju.IdolIns.exception.service;

import com.mju.IdolIns.data.dto.accidentdto.AccidentDto;
import com.mju.IdolIns.data.dto.accidentdto.AccidentResponseDto;

public interface AccidentService {
    AccidentResponseDto getAccident(int accident_NM);
    AccidentResponseDto saveAccident(AccidentDto accidentDto);
    AccidentResponseDto changeAccidentInfo(int accident_NM, String name, String dateOfBirth,
                                           int sex, String accidentDetail, String accidentSpot, String phoneNum) throws Exception;
    void deleteAccident(int accident_NM) throws Exception;
}
