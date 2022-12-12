package com.mju.IdolIns.data.dto.contractordto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ContractorResponseDto {
	private String cont_Fin;
	private int cont_ID;
	private String cont_Start;
	private int cust_ID;
	private int ins_ID;
	private boolean installment;
	private boolean is_Payment;
	private String payDay;
	private String installmentMonth;
	private String lastMonth;
	private boolean effective;
	private String installmentStart;
	
	public ContractorResponseDto() {}

	public ContractorResponseDto(String cont_Fin, int cont_ID, String cont_Start, int cust_ID,
							   int ins_ID, boolean installment, boolean is_Payment, String payDay,
							   String installmentMonth, String lastMonth, boolean effective, String installmentStart) {
		this.cont_Fin = cont_Fin;
		this.cont_ID = cont_ID;
		this.cont_Start = cont_Start;
		this.cust_ID = cust_ID;
		this.ins_ID = ins_ID;
		this.installment = installment;
		this.is_Payment = is_Payment;
		this.payDay = payDay;
		this.installmentMonth = installmentMonth;
		this.lastMonth = lastMonth;
		this.effective = effective;
		this.installmentStart = installmentStart;
	}
}
