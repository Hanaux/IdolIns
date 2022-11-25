package com.mju.IdolIns.data.dto.accidentdto;

import lombok.*;

@Data
@NoArgsConstructor@AllArgsConstructor
@ToString@Builder
public class AccidentDto {
    private String name;
    private String dateOfBirth;
    private int sex;
    private String accidentDetail;
    private String accidentSpot;
    private String phoneNum;
}
