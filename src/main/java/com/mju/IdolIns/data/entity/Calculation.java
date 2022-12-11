package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "calculation_info")
@ToString
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docID;

    @Column(nullable = false)
    private int accNum;

    @Column(nullable = false)
    private int decisionCompensationProperty;

    @Column(nullable = false)
    private int decisionCompensationHuman;



//    @Column(nullable = false)
//    private int custID;
//
//    @Column(nullable = false)
//    private String date;
//
//    @Column(nullable = false)
//    private int paymentReportOK;
//
//    @Column(nullable = false)
//    private int paymentCompleted;

}
