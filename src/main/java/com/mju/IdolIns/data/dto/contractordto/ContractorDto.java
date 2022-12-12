package com.mju.IdolIns.data.dto.contractordto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ContractorDto {
	private String cont_Fin;
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
}
