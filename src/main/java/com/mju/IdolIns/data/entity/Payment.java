package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "payment_info")
@ToString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docID;

    @Column(nullable = false)
    private int accNum;

    @Column(nullable = false)
    private int custID;

    @Column(nullable = false)
    private String date;


}
