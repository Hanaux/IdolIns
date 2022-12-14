package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.Contractordto.ChangeContractorDto;
import com.mju.IdolIns.data.dto.Contractordto.ContractorDto;
import com.mju.IdolIns.data.dto.Contractordto.ContractorResponseDto;
import com.mju.IdolIns.data.dto.customerdto.CustomerResponseDto;
import com.mju.IdolIns.data.entity.Customer;
import com.mju.IdolIns.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mju.IdolIns.service.ContractorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.ArrayList;

@RestController
@Tag(name = "계약", description = "계약 정보 관련 api입니다.")
@RequestMapping("/contractor")
public class ContractorController {
    private final ContractorService contractorService;

    private final CustomerService customerService;

    @Autowired
    public ContractorController(ContractorService contractorService, CustomerService customerService) {
        this.contractorService = contractorService;
        this.customerService = customerService;
    }



    @GetMapping(value = "/continfo/{id}")
    @CrossOrigin
    @Operation(summary = "계약정보 조회 메서드", description = "계약정보 조회 메서드입니다.")
    public ResponseEntity<ContractorResponseDto> getContractor(
            @Parameter @PathVariable int id) {
        ContractorResponseDto contractorResponseDto = contractorService.getContractor(id);

        return ResponseEntity.status(HttpStatus.OK).body(contractorResponseDto);
    }

    @GetMapping(value = "/continfo/customer/{cust_id}")
    @CrossOrigin
    @Operation(summary = "고객 계약정보 조회 메서드", description = "고객의 계약정보 조회 메서드입니다.")
    public ResponseEntity<String> getContractorIDByCustID(
            @Parameter @PathVariable int cust_id) {

        CustomerResponseDto customerResponseDto = customerService.getCustomer(cust_id);

        ArrayList<Customer> customerList = new ArrayList<Customer>();

        if(customerResponseDto != null) {
//			customerList.add(customerResponseDto);
            Customer customer = new Customer();
            customer.setCustId(customerResponseDto.getCust_ID());
            customer.setCustName(customer.getCustName());
            customer.setSSN(customer.getSSN());
            customer.setCustPN(customer.getCustPN());
            customer.setAccNum(customer.getAccNum());
            customer.setSex(customer.getSex());
            customerList.add(customer);
        }
        Customer customer = new Customer();
        for (Customer cust : customerList) {
            if (cust.getCustId() == cust_id) {
                customer = cust;
                break;
            }
        }
        if(customer == null) {
            String message = "Customer is null";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            String conList = contractorService.getContractorID(cust_id);
            return ResponseEntity.status(HttpStatus.OK).body(conList);
        }

//		ContractorResponseDto contractorResponseDto = contractorService.getContractorByCustID(cust_id);

//		return ResponseEntity.status(HttpStatus.OK).body(contractorResponseDto);
    }

    @GetMapping(value = "/continfo/{id}/uw")
    @CrossOrigin
    @Operation(summary = "인수심사 메서드", description = "인수심사 메서드입니다.")
    public ResponseEntity<Float> underwrite(
            @Parameter @PathVariable int insurance_id, @Parameter String jobInfo, @Parameter String insCate) {

        float ratio = contractorService.underwrite(insurance_id, jobInfo, insCate);

        return ResponseEntity.status(HttpStatus.OK).body(ratio);
    }

    @PostMapping(value = "/continfo/enrollment")
    @CrossOrigin
    @Operation(summary = "계약정보 등록 메서드", description = "계약정보 등록 메서드입니다.")
    public ResponseEntity<ContractorResponseDto> createCustomer(@RequestBody ContractorDto contractorDto) {
        ContractorResponseDto contractorResponseDto = contractorService.saveContractor(contractorDto);

        return ResponseEntity.status(HttpStatus.OK).body(contractorResponseDto);
    }

    @PutMapping(value = "/continfo/modification")
    @CrossOrigin
    @Operation(summary = "계약 수정 메서드", description = "계약 수정 메서드입니다.")
    public ResponseEntity<ContractorResponseDto> changeContractor(
            @RequestBody ChangeContractorDto changeContractorDto) throws Exception{
        ContractorResponseDto contractorResponseDto = contractorService.changeContractorInfo(
                changeContractorDto.getCont_Fin(), changeContractorDto.getCont_ID(), changeContractorDto.getCont_Start(),
                changeContractorDto.getCust_ID(), changeContractorDto.getIns_ID(), changeContractorDto.isInstallment(),
                changeContractorDto.is_Payment(), changeContractorDto.getPayDay(), changeContractorDto.getInstallmentMonth(),
                changeContractorDto.getLastMonth(), changeContractorDto.isEffective(), changeContractorDto.getInstallmentStart()
        );

        return ResponseEntity.status(HttpStatus.OK).body(contractorResponseDto);
    }

//	@PutMapping(value = "/continfo/installment_modification")
//	@Operation(summary = "분납 수정 메서드", description = "분납 수정 메서드입니다.")
//	public ResponseEntity<ContractorResponseDto> changeInstallment(
//			@RequestBody ChangeContractorDto changeContractorDto) throws Exception{
//		ContractorResponseDto contractorResponseDto = contractorService.changeContractorInfo(
//				changeContractorDto.getCont_Fin(), changeContractorDto.getCont_ID(), changeContractorDto.getCont_Start(),
//				changeContractorDto.getCust_ID(), changeContractorDto.getIns_ID(), changeContractorDto.isInstallment(),
//				changeContractorDto.is_Payment(), changeContractorDto.getPayDay(), changeContractorDto.getInstallmentMonth(),
//				changeContractorDto.getLastMonth(), changeContractorDto.isEffective(), changeContractorDto.getInstallmentStart()
//		);
//
//		return ResponseEntity.status(HttpStatus.OK).body(contractorResponseDto);
//	}

    @DeleteMapping(value = "/continfo/deletion/{id}")
    @CrossOrigin
    @Operation(summary = "계약 삭제 메서드", description = "계약 삭제 메서드입니다.")
    public ResponseEntity<String> deleteContractor(
            @Parameter @PathVariable int id) throws Exception{
        contractorService.deleteContractor(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }
}
