package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.accidenthandlerdto.AccidentHandlerDto;
import com.mju.IdolIns.data.dto.accidenthandlerdto.AccidentHandlerResponseDto;

public interface AccidentHandlerService {
    AccidentHandlerResponseDto getAccidentHandler(int accident_NM);
    AccidentHandlerResponseDto saveAccidentHandler(AccidentHandlerDto accidentHandlerDto);
    AccidentHandlerResponseDto changeAccidentHandlerInfo(int accident_NM, String accident_Spot, String accident_Detail,
                                                         int cust_ID, int ins_ID, int indemnification, int damage_Amount) throws Exception;
    void deleteAccidentHandler(int accident_NM) throws Exception;
}
