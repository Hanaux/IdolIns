package com.mju.IdolIns.data.repository;

import com.mju.IdolIns.data.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<Calculation, Integer> {
}
