package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dao.CustomerDAO;
import com.mju.IdolIns.data.dto.ChangeCustomerNameDto;
import com.mju.IdolIns.data.dto.CustomerDto;
import com.mju.IdolIns.data.dto.CustomerResponseDto;
import com.mju.IdolIns.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping(value = "/custinfo/{cust_ID}")
    @Operation(summary = "회원정보 조회 메서드", description = "회원정보 조회 메서드입니다.")
    public ResponseEntity<CustomerResponseDto> getCustomer(
            @Parameter(name = "id", description = "고객 id값")
            @RequestParam int cust_ID) {
        CustomerResponseDto customerResponseDto = customerService.getCustomer(cust_ID);

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }

    @PostMapping(value = "/custinfo/enrollment")
    @Operation(summary = "회원정보 등록 메서드", description = "회원정보 등록 메서드입니다.")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerResponseDto customerResponseDto = customerService.saveCustomer(customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }

    @PutMapping()
    public ResponseEntity<CustomerResponseDto> changeCustomerName(
        @RequestBody ChangeCustomerNameDto changeCustomerNameDto) throws Exception{
        CustomerResponseDto customerResponseDto = customerService.changeCustomerName(
                changeCustomerNameDto.getCust_ID(),
                changeCustomerNameDto.getCust_NM()
        );

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteCustomer(int cust_ID) throws Exception{
        customerService.deleteCustomer(cust_ID);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }
}

