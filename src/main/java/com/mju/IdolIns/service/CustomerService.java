package com.mju.IdolIns.service;

import com.mju.IdolIns.data.dto.customerdto.CustomerDto;
import com.mju.IdolIns.data.dto.customerdto.CustomerResponseDto;

public interface CustomerService {
    CustomerResponseDto getCustomer(int cust_ID);
    CustomerResponseDto saveCustomer(CustomerDto customerDto);
    CustomerResponseDto changeCustomerName(int cust_ID, String cust_NM) throws Exception;
    void deleteCustomer(int cust_ID) throws Exception;
}
