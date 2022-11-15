package com.mju.IdolIns.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String custId;
    @Column(nullable = true)
    private String custName;
    @Column(nullable = true)
    private String SSN;
    @Column(nullable = true)
    private String custPN;
    @Column(nullable = true)
    private String accNum;
    @Column(nullable = true)
    private int sex;

}
