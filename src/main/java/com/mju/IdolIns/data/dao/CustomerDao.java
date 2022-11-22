package com.mju.IdolIns.data.dao;

import com.mju.IdolIns.data.entity.Customer;

public interface CustomerDao {
    Customer insertCustomer(Customer customer);
    Customer selectCustomer(int custId);
    Customer updateCustomerName(int custId, String custName) throws Exception;
    void deleteCustomer(int custId) throws Exception;
}
