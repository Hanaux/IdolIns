package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Customer;
import com.mju.IdolIns.exception.CustomException;

import java.util.Optional;

public interface CustomerDao {
    Customer insertCustomer(Customer customer);
    Customer selectCustomer(int custId) throws CustomException;
    Customer updateCustomerName(int custId, String custName) throws Exception;
    void deleteCustomer(int custId) throws Exception;
}
