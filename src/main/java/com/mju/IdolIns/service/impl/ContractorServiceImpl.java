package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.ContractorDao;
import com.mju.IdolIns.data.dto.contractordto.ContractorDto;
import com.mju.IdolIns.data.dto.contractordto.ContractorResponseDto;
import com.mju.IdolIns.data.entity.Contractor;
import com.mju.IdolIns.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorServiceImpl implements ContractorService {

	private final ContractorDao contractorDao;

    @Autowired
    public ContractorServiceImpl(ContractorDao contractorDao){
        this.contractorDao = contractorDao;
    }
	
	@Override
	public ContractorResponseDto getContractor(int cont_ID) {
		Contractor contractor = contractorDao.selectContractor(cont_ID);
		
		ContractorResponseDto contractorResponseDto = new ContractorResponseDto();
		
		contractorResponseDto.setCont_ID(contractor.getContId());
		contractorResponseDto.setCont_Fin(contractor.getContFin());
		contractorResponseDto.setCont_Start(contractor.getContStart());
		contractorResponseDto.setCust_ID(contractor.getCustID());
		contractorResponseDto.setIns_ID(contractor.getInsID());
		contractorResponseDto.setInstallment(contractor.isInstallment());
		contractorResponseDto.set_Payment(contractor.isPayment());
		contractorResponseDto.setPayDay(contractor.getPayDay());
		
		return contractorResponseDto;
	}

	@Override
	public ContractorResponseDto saveContractor(ContractorDto contractorDto) {
		Contractor contractor = new Contractor();
		contractor.setContFin(contractorDto.getCont_Fin());
		contractor.setContStart(contractorDto.getCont_Start());
		contractor.setCustID(contractorDto.getCust_ID());
		contractor.setInsID(contractorDto.getIns_ID());
		contractor.setInstallment(contractorDto.isInstallment());
		contractor.setPayment(contractorDto.is_Payment());
		contractor.setPayDay(contractorDto.getPayDay());
		contractor.setInstallmentMonth(contractorDto.getInstallmentMonth());
		contractor.setLastMonth(contractorDto.getLastMonth());
		contractor.setEffective(contractorDto.isEffective());
		contractor.setInstallmentStart(contractorDto.getInstallmentStart());
		
		Contractor savedContract = contractorDao.insertContractor(contractor);
		
		ContractorResponseDto contractorResponseDto = new ContractorResponseDto();
		
		contractorResponseDto.setCont_ID(savedContract.getContId());
		contractorResponseDto.setCont_Fin(savedContract.getContFin());
		contractorResponseDto.setCont_Start(savedContract.getContStart());
		contractorResponseDto.setCust_ID(savedContract.getCustID());
		contractorResponseDto.setIns_ID(savedContract.getInsID());
		contractorResponseDto.setInstallment(savedContract.isInstallment());
		contractorResponseDto.set_Payment(savedContract.isPayment());
		contractorResponseDto.setPayDay(savedContract.getPayDay());
		contractorResponseDto.setInstallmentMonth(savedContract.getInstallmentMonth());
		contractorResponseDto.setLastMonth(savedContract.getLastMonth());
		contractorResponseDto.setEffective(savedContract.isEffective());
		contractorResponseDto.setInstallmentStart(savedContract.getInstallmentStart());
		
		return contractorResponseDto;
	}

	@Override
	public ContractorResponseDto changeContractorInfo(String cont_Fin, int cont_ID, String cont_Start, int cust_ID, int ins_ID,
			boolean installment, boolean is_Payment, String pay_Day,
			String installmentMonth, String lastMonth, boolean effective, String installmentStart) throws Exception {
		Contractor changedContractor = contractorDao.updateContractor(cont_Fin, cont_ID, cont_Start, cust_ID, ins_ID, installment, is_Payment, pay_Day, installmentMonth, lastMonth, effective, installmentStart);
		
		ContractorResponseDto contractorResponseDto = new ContractorResponseDto();
		contractorResponseDto.setCont_ID(changedContractor.getContId());
		contractorResponseDto.setCont_Fin(changedContractor.getContFin());
		contractorResponseDto.setCont_Start(changedContractor.getContStart());
		contractorResponseDto.setCust_ID(changedContractor.getCustID());
		contractorResponseDto.setIns_ID(changedContractor.getInsID());
		contractorResponseDto.setInstallment(changedContractor.isInstallment());
		contractorResponseDto.set_Payment(changedContractor.isPayment());
		contractorResponseDto.setPayDay(changedContractor.getPayDay());
		
		return contractorResponseDto;
	}
	
	@Override
	public void deleteContractor(int cont_ID) throws Exception {
		contractorDao.deleteContractor(cont_ID);
	}

	@Override
	public String getContractorID(int cust_id) {
		List<Contractor> contractors = contractorDao.selectAllContractor();

		String conList = "";
		for(Contractor contractor : contractors) {
			if(contractor.getCustID() == cust_id)
				conList += contractor.getCustID() + " ";
		}
		return conList;
	}

	@Override
	public float underwrite(int insurance_id, String jobInfo, String insCate) {
		float ratio = 1;

		switch(insCate) {
			case "VI" :
				if(jobInfo.equals("transport,warehousing,telecommunications")) ratio= (float) 1.2;
				break;
			case "MI" :
				if(jobInfo.equals("fishing")) ratio= (float) 1.3;
				if(jobInfo.equals("transport,warehousing,telecommunications")) ratio= (float) 1.1;
				break;
			case "FI" :
				if(jobInfo.equals("electricity,gas,steam,waterworks")) ratio= (float) 1.3;
				if(jobInfo.equals("manufacturing")) ratio= (float) 1.3;
				if(jobInfo.equals("construction")) ratio= (float) 1.2;
			default :
				break;
		}

		return ratio;
	}
}
