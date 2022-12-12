package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.paycheckdto.ChangePaycheckInfoDto;
import com.mju.IdolIns.data.dto.paycheckdto.PaycheckDto;
import com.mju.IdolIns.data.dto.paycheckdto.PaycheckResponseDto;
import com.mju.IdolIns.service.PaycheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "지급확인", description = "지급확인 정보 관련 api입니다.")
@RequestMapping("/Paycheck")
public class PaycheckController {
    private final PaycheckService paycheckService;

    @Autowired
    public PaycheckController(PaycheckService paycheckService) {
        this.paycheckService = paycheckService;
    }

    @GetMapping(value = "/paycheckinfo/{id}")
    @CrossOrigin
    @Operation(summary = "지급확인정보 조회 메서드", description = "지급확인정보 조회 메서드입니다.")
    public ResponseEntity<PaycheckResponseDto> getPaycheck(
            @Parameter @PathVariable int id) {
        PaycheckResponseDto paycheckResponseDto = paycheckService.getPaycheck(id);

        return ResponseEntity.status(HttpStatus.OK).body(paycheckResponseDto);
    }

    @PostMapping(value = "/paycheckinfo/enrollment")
    @CrossOrigin
    @Operation(summary = "지급확인정보 등록 메서드", description = "지급확인정보 등록 메서드입니다.")
    public ResponseEntity<PaycheckResponseDto> createPaycheck(@RequestBody PaycheckDto paycheckDto) {
        PaycheckResponseDto paycheckResponseDto = paycheckService.savePaycheck(paycheckDto);

        return ResponseEntity.status(HttpStatus.OK).body(paycheckResponseDto);
    }

    @PutMapping(value = "/paycheckinfo/modification")
    @CrossOrigin
    @Operation(summary = "지급확인 정보 수정 메서드", description = "지급확인정보 수정 메서드입니다.")
    public ResponseEntity<PaycheckResponseDto> changePaycheck(
        @RequestBody ChangePaycheckInfoDto changePaycheckInfoDto) throws Exception{
        PaycheckResponseDto paycheckResponseDto = paycheckService.changePaycheckInfo(
                changePaycheckInfoDto.getPayCheckID(), changePaycheckInfoDto.getPayID(), changePaycheckInfoDto.getPaymentReportOK(), changePaycheckInfoDto.getPaymentCompleted()
        );

        return ResponseEntity.status(HttpStatus.OK).body(paycheckResponseDto);
    }

    @DeleteMapping(value = "/paycheckinfo/deletion/{id}")
    @CrossOrigin
    @Operation(summary = "지급확인 정보 삭제 메서드", description = "지급확인정보 삭제 메서드입니다.")
    public ResponseEntity<String> deletePaycheck(
            @Parameter @PathVariable
            int id) throws Exception{
        paycheckService.deletePaycheck(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }

}

