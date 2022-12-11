package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "charger_info")
@ToString
public class Charger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chargerNum;

    @Column(nullable = false)
    private int insid;

    @Column(nullable = false)
    private int custid;

    @Column(nullable = false)
    private int lossAmountHuman;

    @Column(nullable = false)
    private int lossAmountProperty;

}
