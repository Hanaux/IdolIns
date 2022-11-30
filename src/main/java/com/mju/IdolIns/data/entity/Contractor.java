package com.mju.IdolIns.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "cont_info")
@ToString
public class Contractor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contId;
	
	@Column(nullable = false)
    private String contFin;
	
	@Column(nullable = false)
    private String contStart;
	
	@Column(nullable = false)
    private int custID;
	
	@Column(nullable = false)
    private int insID;
	
	@Column(nullable = false)
    private boolean installment;
	
	@Column(nullable = false)
    private boolean isPayment;
	
	@Column(nullable = false)
    private String payDay;

    @Column(nullable = false)
    private String installmentMonth;

    @Column(nullable = false)
    private String lastMonth;

    @Column(nullable = false)
    private boolean effective;

    @Column(nullable = false)
    private String installmentStart;
}
