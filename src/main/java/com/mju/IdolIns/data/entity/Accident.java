package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter@Setter@Entity
@NoArgsConstructor@AllArgsConstructor@EqualsAndHashCode
@Table(name = "acc_info") @ToString
public class Accident{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accNum;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private int sex;

    @Column(nullable = false)
    private String accidentDetail;

    @Column(nullable = false)
    private String accidentSpot;

    @Column(nullable = false)
    private String phoneNum;
}
