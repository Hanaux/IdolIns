package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.insurancedto.ChangeInsuranceNameDto;
import com.mju.IdolIns.data.dto.insurancedto.InsuranceDto;
import com.mju.IdolIns.data.dto.insurancedto.InsuranceResponseDto;
import com.mju.IdolIns.service.InsuranceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "보험", description = "보험 정보 관련 api입니다.")
@RequestMapping("/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping(value = "/insinfo/{id}")
    @Operation(summary = "보험정보 조회 메서드", description = "보험정보 조회 메서드입니다.")
    public ResponseEntity<InsuranceResponseDto> getInsurance(
            @Parameter @PathVariable int id) {
        InsuranceResponseDto insuranceResponseDto = insuranceService.getInsurance(id);

        return ResponseEntity.status(HttpStatus.OK).body(insuranceResponseDto);
    }

    @PostMapping(value = "/insinfo/enrollment")
    @Operation(summary = "보험정보 등록 메서드", description = "보험정보 등록 메서드입니다.")
    public ResponseEntity<InsuranceResponseDto> createInsurance(@RequestBody InsuranceDto insuranceDto) {
        InsuranceResponseDto insuranceResponseDto = insuranceService.saveInsurance(insuranceDto);

        return ResponseEntity.status(HttpStatus.OK).body(insuranceResponseDto);
    }

    @PutMapping(value = "/insinfo/modification")
    @Operation(summary = "보험 이름 수정 메서드", description = "보험정보 이름 수정 메서드입니다.")
    public ResponseEntity<InsuranceResponseDto> changeCustomerName(
        @RequestBody ChangeInsuranceNameDto changeInsuranceNameDto) throws Exception{
        InsuranceResponseDto insuranceResponseDto = insuranceService.changeInsuranceName(
                changeInsuranceNameDto.getIns_ID(),
                changeInsuranceNameDto.getIns_NM()
        );

        return ResponseEntity.status(HttpStatus.OK).body(insuranceResponseDto);
    }

    @DeleteMapping(value = "/insinfo/deletion/{id}")
    @Operation(summary = "보험 정보 삭제 메서드", description = "보험정보 삭제 메서드입니다.")
    public ResponseEntity<String> deleteInsurance(
            @Parameter @PathVariable
            int id) throws Exception{
        insuranceService.deleteInsurance(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }
}

