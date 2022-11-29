package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.AccidentHandler;

public interface AccidentHandlerDao {
    AccidentHandler insertAccidentHandler(AccidentHandler accidentHandler);
    AccidentHandler selectAccidentHandler(int accident_NM);
    AccidentHandler updateAccidentHandler(int accident_NM, String accident_Spot, String accident_Detail,
                                          int cust_ID, int ins_ID, int indemnification, int damage_Amount) throws Exception;
    void deleteAccidentHandler(int accident_NM) throws Exception;
}
