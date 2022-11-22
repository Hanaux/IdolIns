package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter@Setter@Entity
@NoArgsConstructor@AllArgsConstructor@EqualsAndHashCode
@Table(name = "acchandler_info") @ToString
public class AccidentHandler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accNum;

    @Column(nullable = false)
    private String accidentSpot;

    @Column(nullable = false)
    private String accidentDetail;

    @Column(nullable = false)
    private int custId;

    @Column(nullable = false)
    private int insId;

    @Column(nullable = false)
    private int indemnification;

    @Column(nullable = false)
    private int damageAmount;
}
