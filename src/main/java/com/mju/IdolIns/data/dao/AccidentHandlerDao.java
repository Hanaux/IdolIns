package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.AccidentHandler;
import com.mju.IdolIns.exception.CustomException;

public interface AccidentHandlerDao {
    AccidentHandler insertAccidentHandler(AccidentHandler accidentHandler) throws CustomException;
    AccidentHandler selectAccidentHandler(int accident_NM) throws CustomException;
    AccidentHandler updateAccidentHandler(int accident_NM, String accident_Spot, String accident_Detail,
                                          int cust_ID, int ins_ID, int indemnification, int damage_Amount) throws CustomException;
    void deleteAccidentHandler(int accident_NM) throws CustomException;
}
