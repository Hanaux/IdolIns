package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter@Setter@Entity
@NoArgsConstructor@AllArgsConstructor@EqualsAndHashCode
@Table(name = "center_info") @ToString
public class InsuranceCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int centerNum;

    @Column(nullable = false)
    private String centerName;

    @Column(nullable = false)
    private String centerLocation;

    @Column(nullable = false)
    private String centerAddress;
}
