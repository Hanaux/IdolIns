package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "ins_info")
@ToString
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int insId;

    @Column(nullable = false)
    private String insName;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String target_Cust;

    @Column(nullable = false)
    private String detail;

    @Column(nullable = false)
    private int insFee;

    @Column(nullable = false)
    private int rate;

    @Column(nullable = false)
    private int compensation;

    @Column(nullable = false)
    private int permission;

}