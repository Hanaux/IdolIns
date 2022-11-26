package com.mju.IdolIns.data.repository;

import com.mju.IdolIns.data.entity.Paycheck;
import com.mju.IdolIns.data.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaycheckRepository extends JpaRepository<Paycheck, Integer> {
}
