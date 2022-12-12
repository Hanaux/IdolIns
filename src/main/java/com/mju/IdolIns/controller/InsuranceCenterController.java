package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.insurancecenterdto.ChangeInsuranceCenterInfoDto;
import com.mju.IdolIns.data.dto.insurancecenterdto.InsuranceCenterDto;
import com.mju.IdolIns.data.dto.insurancecenterdto.InsuranceCenterResponseDto;
import com.mju.IdolIns.exception.service.InsuranceCenterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "보험사 출동 센터", description = "보험사 출동 센터 관련 api입니다.")
@RequestMapping("/insurance/center")
public class InsuranceCenterController {
    private final InsuranceCenterService insuranceCenterService;

    @Autowired
    public InsuranceCenterController(InsuranceCenterService insuranceCenterService) {this.insuranceCenterService = insuranceCenterService;}

    @GetMapping(value = "/centerinfo/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "센터정보 조회 메서드", description = "센터정보 조회 메서드입니다.")
    public ResponseEntity<InsuranceCenterResponseDto> getInsuranceCenter(
            @Parameter @PathVariable int id) {
        InsuranceCenterResponseDto insuranceCenterResponseDto = insuranceCenterService.getInsuranceCenter(id);

        return ResponseEntity.status(HttpStatus.OK).body(insuranceCenterResponseDto);
    }

    @PostMapping(value = "/centerinfo/enrollment")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "센터정보 등록 메서드", description = "센터정보 등록 메서드입니다.")
    public ResponseEntity<InsuranceCenterResponseDto> createInsuranceCenter(@RequestBody InsuranceCenterDto insuranceCenterDto) {
        InsuranceCenterResponseDto insuranceCenterResponseDto = insuranceCenterService.saveInsuranceCenter(insuranceCenterDto);

        return ResponseEntity.status(HttpStatus.OK).body(insuranceCenterResponseDto);
    }

    @PutMapping(value = "/centerinfo/modification")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "센터정보 수정 메서드", description = "센터정보 수정 메서드입니다.")
    public ResponseEntity<InsuranceCenterResponseDto> changeInsuranceCenterInfo(
            @RequestBody ChangeInsuranceCenterInfoDto changeInsuranceCenterInfoDto) throws Exception{
        InsuranceCenterResponseDto centerResponseDto = insuranceCenterService.changeInsuranceCenterInfo(
                changeInsuranceCenterInfoDto.getCenterNum(),
                changeInsuranceCenterInfoDto.getCenterName(),
                changeInsuranceCenterInfoDto.getCenterLocation(),
                changeInsuranceCenterInfoDto.getCenterAddress(),
                changeInsuranceCenterInfoDto.getCenterHotline()
        );

        return ResponseEntity.status(HttpStatus.OK).body(centerResponseDto);
    }

    @DeleteMapping(value = "/centerinfo/deletion/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "센터정보 삭제 메서드", description = "센터정보 삭제 메서드입니다.")
    public ResponseEntity<String> deleteInsuranceCenter(
            @Parameter @PathVariable int id
    ) throws Exception{
        insuranceCenterService.deleteInsuranceCenter(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }
}
