package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.Contractordto.ContractorDto;
import com.mju.IdolIns.data.dto.Contractordto.ContractorResponseDto;

import java.util.List;

public interface ContractorService {
    ContractorResponseDto getContractor(int cont_ID);
    ContractorResponseDto saveContractor(ContractorDto contractorDto);
    ContractorResponseDto changeContractorInfo(String cont_Fin, int cont_ID, String cont_Start, int cust_ID, int ins_ID, boolean installment, boolean is_Payment, String payDay, String installmentMonth, String lastMonth, boolean effective, String installmentStart) throws Exception;
    void deleteContractor(int cont_ID) throws Exception;
    String getContractorID(int cust_id);

    float underwrite(int insurance_id, String jobInfo, String insCate);
}