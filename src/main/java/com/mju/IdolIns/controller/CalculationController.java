package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.calculationdto.CalculationDto;
import com.mju.IdolIns.data.dto.calculationdto.CalculationResponseDto;
import com.mju.IdolIns.data.dto.calculationdto.ChangeCalculationInfoDto;
import com.mju.IdolIns.service.CalculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "산출", description = "산출 정보 관련 api입니다.")
@RequestMapping("/Calculation")
public class CalculationController {
    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping(value = "/calculationinfo/{id}")
    @CrossOrigin
    @Operation(summary = "산출정보 조회 메서드", description = "산출정보 조회 메서드입니다.")
    public ResponseEntity<CalculationResponseDto> getCalculation(
            @Parameter @PathVariable int id) {
        CalculationResponseDto calculationResponseDto = calculationService.getCalculation(id);

        return ResponseEntity.status(HttpStatus.OK).body(calculationResponseDto);
    }

    @PostMapping(value = "/calculationinfo/enrollment")
    @CrossOrigin
    @Operation(summary = "산출정보 등록 메서드", description = "산출정보 등록 메서드입니다.")
    public ResponseEntity<CalculationResponseDto> createCalculation(@RequestBody CalculationDto calculationDto) {
        CalculationResponseDto calculationResponseDto = calculationService.saveCalculation(calculationDto);

        return ResponseEntity.status(HttpStatus.OK).body(calculationResponseDto);
    }

    @PutMapping(value = "/calculationinfo/modification")
    @CrossOrigin
    @Operation(summary = "산출 정보 수정 메서드", description = "산출정보 수정 메서드입니다.")
    public ResponseEntity<CalculationResponseDto> changeCalculation(
        @RequestBody ChangeCalculationInfoDto changeCalculationInfoDto) throws Exception{
        CalculationResponseDto calculationResponseDto = calculationService.changeCalculationInfo(
                changeCalculationInfoDto.getDocID(), changeCalculationInfoDto.getAcc_NM(), changeCalculationInfoDto.getDecisionCompensationProperty(),
                changeCalculationInfoDto.getDecisionCompensationHuman()
        );

        return ResponseEntity.status(HttpStatus.OK).body(calculationResponseDto);
    }

    @DeleteMapping(value = "/calculationinfo/deletion/{id}")
    @CrossOrigin
    @Operation(summary = "산출 정보 삭제 메서드", description = "산출정보 삭제 메서드입니다.")
    public ResponseEntity<String> deleteCharger(
            @Parameter @PathVariable
            int id) throws Exception{
        calculationService.deleteCalculation(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }
}

