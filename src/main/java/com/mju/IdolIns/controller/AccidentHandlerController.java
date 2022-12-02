package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.accidenthandlerdto.AccidentHandlerDto;
import com.mju.IdolIns.data.dto.accidenthandlerdto.AccidentHandlerResponseDto;
import com.mju.IdolIns.data.dto.accidenthandlerdto.ChangeAccidentHandlerDto;
import com.mju.IdolIns.service.AccidentHandlerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "사고처리", description = "사고처리 관련 api입니다.")
@RequestMapping("/acchandler")
public class AccidentHandlerController {
    private final AccidentHandlerService accidentHandlerService;

    @Autowired
    public AccidentHandlerController(AccidentHandlerService accidentHandlerService){this.accidentHandlerService = accidentHandlerService;}

    @GetMapping(value = "/acchandlerinfo/{id}")
    @Operation(summary = "사고처리 조회 메서드", description = "사고처리 조회 메서드입니다.")
    public ResponseEntity<AccidentHandlerResponseDto> getAccidentHandler(
            @Parameter @PathVariable int id) {
        AccidentHandlerResponseDto accidentHandlerResponseDto = accidentHandlerService.getAccidentHandler(id);

        return ResponseEntity.status(HttpStatus.OK).body(accidentHandlerResponseDto);
    }

    @PostMapping(value = "/acchandlerinfo/enrollment")
    @Operation(summary = "사고처리 등록 메서드", description = "사고처리 등록 메서드입니다.")
    public ResponseEntity<AccidentHandlerResponseDto> createAccidentHandler(@RequestBody AccidentHandlerDto accidentHandlerDto){
        AccidentHandlerResponseDto accidentHandlerResponseDto = accidentHandlerService.saveAccidentHandler(accidentHandlerDto);

        return ResponseEntity.status(HttpStatus.OK).body(accidentHandlerResponseDto);
    }

    @PutMapping(value = "/acchandlerinfo/modification")
    @Operation(summary = "사고처리 수정 메서드", description = "사고처리 수정 메서드입니다.")
    public ResponseEntity<AccidentHandlerResponseDto> changeAccidentHandler(
            @RequestBody ChangeAccidentHandlerDto changeAccidentHandlerDto)throws Exception{
        AccidentHandlerResponseDto accidentHandlerResponseDto = accidentHandlerService.changeAccidentHandlerInfo(
                changeAccidentHandlerDto.getAcc_NM(), changeAccidentHandlerDto.getAcc_Spot(), changeAccidentHandlerDto.getAcc_Detail(),
                changeAccidentHandlerDto.getCust_ID(), changeAccidentHandlerDto.getIns_ID(), changeAccidentHandlerDto.getIndemn(),
                changeAccidentHandlerDto.getDam_Amount()
        );
        return ResponseEntity.status(HttpStatus.OK).body(accidentHandlerResponseDto);
    }

    @DeleteMapping(value = "/acchandlerinfo/deletion/{id}")
    @Operation(summary = "사고처리 삭제 메서드", description = "사고처리 삭제 메서드입니다.")
    public ResponseEntity<String> deleteAccidentHandler(
            @Parameter @PathVariable int id) throws Exception{
        accidentHandlerService.deleteAccidentHandler(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }
}