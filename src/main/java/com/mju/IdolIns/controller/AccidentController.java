package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.accidentdto.AccidentDto;
import com.mju.IdolIns.data.dto.accidentdto.AccidentResponseDto;
import com.mju.IdolIns.data.dto.accidentdto.ChangeAccidentDto;
import com.mju.IdolIns.service.AccidentDispatchService;
import com.mju.IdolIns.service.AccidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name  = "사고접수", description = "사고접수 관련 api입니다.")
@RequestMapping("/accident")
public class AccidentController {
    private final AccidentService accidentService;
    private final AccidentDispatchService accidentDispatchService;

    @Autowired
    public AccidentController(AccidentService accidentService, AccidentDispatchService accidentDispatchService){
        this.accidentService = accidentService;
        this.accidentDispatchService = accidentDispatchService;
    }

    @GetMapping(value = "/accidentinfo/{id}")
    @CrossOrigin
    @Operation(summary = "사고접수 조회 메서드", description = "사고접수 조회 메서드입니다.")
    public ResponseEntity<AccidentResponseDto> getAccident(
            @Parameter@PathVariable int id
    ){
        AccidentResponseDto accidentResponseDto = accidentService.getAccident(id);

        return ResponseEntity.status(HttpStatus.OK).body(accidentResponseDto);
    }

    @GetMapping(value = "/accidentinfo/dispatch")
    @CrossOrigin
    @Operation(summary = "사고접수 최근접 센터 조회 메서드", description = "사고접수 최근접 센터 조회 메서드입니다.")
    public ResponseEntity<String> getDistpatchCenter(
//            @RequestBody String accidentSpot
              @Parameter String accidentSpot
    ){
        String dispatchInfo = accidentDispatchService.getCenter(accidentSpot);
        System.out.println("why andem");
        return ResponseEntity.status(HttpStatus.OK).body(dispatchInfo);
    }

    @PostMapping(value = "/accidentinfo/enrollment")
    @CrossOrigin
    @Operation(summary = "사고접수 등록 메서드", description = "사고접수 등록 메서드입니다.")
    public ResponseEntity<AccidentResponseDto> createAccident(@RequestBody AccidentDto accidentDto){
        AccidentResponseDto accidentResponseDto = accidentService.saveAccident(accidentDto);

        return ResponseEntity.status(HttpStatus.OK).body(accidentResponseDto);
    }

    @PutMapping(value = "/accidentinfo/modification")
    @CrossOrigin
    @Operation(summary = "사고접수 수정 메서드", description = "사고접수 수정 메서드")
    public ResponseEntity<AccidentResponseDto> changeAccident(
            @RequestBody ChangeAccidentDto changeAccidentDto)throws Exception{
        AccidentResponseDto accidentResponseDto = accidentService.changeAccidentInfo(
                changeAccidentDto.getAccNum(), changeAccidentDto.getName(), changeAccidentDto.getDateOfBirth(),
                changeAccidentDto.getSex(), changeAccidentDto.getAccDetail(), changeAccidentDto.getAccSpot(),
                changeAccidentDto.getPhoneNum());
        return ResponseEntity.status(HttpStatus.OK).body(accidentResponseDto);
    }

    @DeleteMapping(value = "/accidentinfo/deletion/{id}")
    @CrossOrigin
    @Operation(summary = "사고접수 삭제 메서드", description = "사고접수 삭제 메서드입니다.")
    public ResponseEntity<String> deleteAccident(
            @Parameter @PathVariable int id
    ) throws Exception{
        accidentService.deleteAccident(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }

}
