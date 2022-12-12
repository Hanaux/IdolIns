package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.paymentdto.ChangePaymentInfoDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentDto;
import com.mju.IdolIns.data.dto.paymentdto.PaymentResponseDto;
import com.mju.IdolIns.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "지급", description = "지급 정보 관련 api입니다.")
@RequestMapping("/Payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/paymentinfo/{id}")
    @CrossOrigin
    @Operation(summary = "지급정보 조회 메서드", description = "지급정보 조회 메서드입니다.")
    public ResponseEntity<PaymentResponseDto> getPayment(
            @Parameter @PathVariable int id) {
        PaymentResponseDto paymentResponseDto = paymentService.getPayment(id);

        return ResponseEntity.status(HttpStatus.OK).body(paymentResponseDto);
    }

    @PostMapping(value = "/paymentinfo/enrollment")
    @CrossOrigin
    @Operation(summary = "지급정보 등록 메서드", description = "지급정보 등록 메서드입니다.")
    public ResponseEntity<PaymentResponseDto> createPayment(@RequestBody PaymentDto paymentDto) {
        PaymentResponseDto paymentResponseDto = paymentService.savePayment(paymentDto);

        return ResponseEntity.status(HttpStatus.OK).body(paymentResponseDto);
    }

    @PutMapping(value = "/paymentinfo/modification")
    @CrossOrigin
    @Operation(summary = "지급 정보 수정 메서드", description = "지급정보 수정 메서드입니다.")
    public ResponseEntity<PaymentResponseDto> changePayment(
        @RequestBody ChangePaymentInfoDto changePaymentInfoDto) throws Exception{
        PaymentResponseDto paymentResponseDto = paymentService.changePaymentInfo(
                changePaymentInfoDto.getPayID(), changePaymentInfoDto.getDocID(), changePaymentInfoDto.getDate(),
                changePaymentInfoDto.getAccNum(), changePaymentInfoDto.getChargerNum(), changePaymentInfoDto.getCustID()
        );

        return ResponseEntity.status(HttpStatus.OK).body(paymentResponseDto);
    }

    @DeleteMapping(value = "/paymentinfo/deletion/{id}")
    @CrossOrigin
    @Operation(summary = "청구 정보 삭제 메서드", description = "청구정보 삭제 메서드입니다.")
    public ResponseEntity<String> deletePayment(
            @Parameter @PathVariable
            int id) throws Exception{
        paymentService.deletePayment(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }

}

