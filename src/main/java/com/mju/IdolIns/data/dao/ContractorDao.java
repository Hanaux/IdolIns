package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Contractor;

import java.util.List;

public interface ContractorDao {
	Contractor insertContractor(Contractor contractor);
	Contractor selectContractor(int cont_ID);
	Contractor updateContractor(String contFin, int cont_ID, String cont_Start, int cust_ID,  
								int ins_ID, boolean installment, boolean is_Payment, String pay_Day,
								String installmentMonth, String lastMonth, boolean effective, String installmentStart) throws Exception;
    void deleteContractor(int cont_ID) throws Exception;

	List<Contractor> selectAllContractor();
}
