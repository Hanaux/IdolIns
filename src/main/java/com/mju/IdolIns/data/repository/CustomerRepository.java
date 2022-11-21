package com.mju.IdolIns.data.repository;

import com.mju.IdolIns.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
