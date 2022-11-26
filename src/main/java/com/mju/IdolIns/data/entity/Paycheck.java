package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "paycheck_info")
@ToString
public class Paycheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docID;

    @Column(nullable = false)
    private int paymentReportOK;

    @Column(nullable = false)
    private int paymentCompleted;

}
