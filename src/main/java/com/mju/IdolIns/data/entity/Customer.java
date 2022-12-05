package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "cust_info")
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Column(nullable = false)
    private String custName;

    @Column(nullable = false)
    private String SSN;

    @Column(nullable = false)
    private String custPN;

    @Column(nullable = false)
    private String accNum;

    @Column(nullable = false)
    private int sex;

    @Column(nullable = false)
    private String job;

}
