package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.customerdto.ChangeCustomerNameDto;
import com.mju.IdolIns.data.dto.customerdto.CustomerDto;
import com.mju.IdolIns.data.dto.customerdto.CustomerResponseDto;
import com.mju.IdolIns.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "고객", description = "고객 정보 관련 api입니다.")
@RequestMapping("/customer")
public class CustomerController{
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/custinfo/{id}")
    @Operation(summary = "회원정보 조회 메서드", description = "회원정보 조회 메서드입니다.")
    public ResponseEntity<CustomerResponseDto> getCustomer(
            @Parameter @PathVariable int id) {
        CustomerResponseDto customerResponseDto = customerService.getCustomer(id);

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }

    @PostMapping(value = "/custinfo/enrollment")
    @Operation(summary = "회원정보 등록 메서드", description = "회원정보 등록 메서드입니다.")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerResponseDto customerResponseDto = customerService.saveCustomer(customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }

    @PutMapping(value = "/custinfo/modification")
    @Operation(summary = "회원 이름 수정 메서드", description = "회원정보 이름 수정 메서드입니다.")
    public ResponseEntity<CustomerResponseDto> changeCustomerName(
        @RequestBody ChangeCustomerNameDto changeCustomerNameDto) throws Exception{
        CustomerResponseDto customerResponseDto = customerService.changeCustomerName(
                changeCustomerNameDto.getCust_ID(),
                changeCustomerNameDto.getCust_NM()
        );

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }

    @DeleteMapping(value = "/custinfo/deletion/{id}")
    @Operation(summary = "회원 정보 삭제 메서드", description = "회원정보 삭제 메서드입니다.")
    public ResponseEntity<String> deleteCustomer(
            @Parameter @PathVariable
            int id) throws Exception{
        customerService.deleteCustomer(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }
}

