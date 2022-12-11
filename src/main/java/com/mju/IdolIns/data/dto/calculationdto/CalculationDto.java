package com.mju.IdolIns.data.dto.calculationdto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CalculationDto {
    private int Accident_NM;
    private int DecisionCompensationProperty;
    private int DecisionCompensationHuman;

}
