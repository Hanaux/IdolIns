package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.ContractorDao;
import com.mju.IdolIns.data.entity.Contractor;
import com.mju.IdolIns.data.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContractorDaoImpl implements ContractorDao {
	private final ContractorRepository contractorRepository;
	
	@Autowired
	public ContractorDaoImpl(ContractorRepository contractorRepository) {this.contractorRepository = contractorRepository; }

	@Override
	public Contractor insertContractor(Contractor contractor) {
		Contractor savedContractor = contractorRepository.save(contractor);
		return savedContractor;
	}

	@Override
	public Contractor selectContractor(int contID) {
		Contractor selectedContractor = contractorRepository.getById(contID);
		return selectedContractor;
	}

	@Override
	public Contractor updateContractor(String cont_Fin, int cont_ID, String cont_Start, int cust_ID,
									   int ins_ID, boolean installment, boolean is_Payment, String pay_Day,
									   String installmentMonth, String lastMonth, boolean effective, String installmentStart) throws Exception {
		Optional<Contractor> selectedContractor = contractorRepository.findById(cont_ID);
		
		Contractor updateContractor;
		
		if(selectedContractor.isPresent()) {
			Contractor contractor = selectedContractor.get();
			
			contractor.setContFin(cont_Fin);
			contractor.setContStart(cont_Start);
			contractor.setCustID(cust_ID);
			contractor.setInsID(ins_ID);
			contractor.setInstallment(installment);
			contractor.setPayment(is_Payment);
			contractor.setPayDay(pay_Day);
			contractor.setInstallmentMonth(installmentMonth);
			contractor.setLastMonth(lastMonth);
			contractor.setEffective(effective);
			contractor.setInstallmentStart(installmentStart);
			
			updateContractor = contractorRepository.save(contractor);
		} else {
			throw new Exception();
		}
		return updateContractor;
	}

	@Override
	public void deleteContractor(int cont_ID) throws Exception {
		Optional<Contractor> selectedContractor = contractorRepository.findById(cont_ID);
		
		if(selectedContractor.isPresent()) {
			Contractor contractor = selectedContractor.get();
			contractorRepository.delete(contractor);
		} else {
			throw new Exception();
		}
	}

	@Override
	public List<Contractor> selectAllContractor() {
		List<Contractor> contractors = contractorRepository.findAll();
		return contractors;
	}

//	@Override
//	public Contractor selectContractorByCustID(int cust_id) {
//		Contractor selectedContractor = contractorRepository.getByCustId(cust_id);
//		return selectedContractor;
//	}

}
