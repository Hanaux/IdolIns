package com.mju.IdolIns.controller;

import com.mju.IdolIns.data.dto.chargerdto.ChangeChargerInfoDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerDto;
import com.mju.IdolIns.data.dto.chargerdto.ChargerResponseDto;
import com.mju.IdolIns.service.ChargerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "청구", description = "청구 정보 관련 api입니다.")
@RequestMapping("/Charger")
public class ChargerController {
    private final ChargerService chargerService;

    @Autowired
    public ChargerController(ChargerService chargerService) {
        this.chargerService = chargerService;
    }

    @GetMapping(value = "/chargerinfo/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "청구정보 조회 메서드", description = "청구정보 조회 메서드입니다.")
    public ResponseEntity<ChargerResponseDto> getCharger(
            @Parameter @PathVariable int id) {
        ChargerResponseDto chargerResponseDto = chargerService.getCharger(id);

        return ResponseEntity.status(HttpStatus.OK).body(chargerResponseDto);
    }

    @PostMapping(value = "/chargerinfo/enrollment")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "청구정보 등록 메서드", description = "청구정보 등록 메서드입니다.")
    public ResponseEntity<ChargerResponseDto> createCharger(@RequestBody ChargerDto chargerDto) {
        ChargerResponseDto chargerResponseDto = chargerService.saveCharger(chargerDto);

        return ResponseEntity.status(HttpStatus.OK).body(chargerResponseDto);
    }

    @PutMapping(value = "/chargerinfo/modification")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "청구 정보 수정 메서드", description = "청구정보 수정 메서드입니다.")
    public ResponseEntity<ChargerResponseDto> changeCharger(
        @RequestBody ChangeChargerInfoDto changeChargerInfoDto) throws Exception{
        ChargerResponseDto chargerResponseDto = chargerService.changeChargerInfo(
                changeChargerInfoDto.getAcc_NM(), changeChargerInfoDto.getIns_ID(), changeChargerInfoDto.getLossAmountHuman(),
                changeChargerInfoDto.getLossAmountProperty()
        );

        return ResponseEntity.status(HttpStatus.OK).body(chargerResponseDto);
    }

    @DeleteMapping(value = "/chargerinfo/deletion/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "청구 정보 삭제 메서드", description = "청구정보 삭제 메서드입니다.")
    public ResponseEntity<String> deleteCharger(
            @Parameter @PathVariable
            int id) throws Exception{
        chargerService.deleteCharger(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }

}

