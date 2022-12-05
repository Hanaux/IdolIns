package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.CustomerDao;
import com.mju.IdolIns.data.dto.customerdto.CustomerDto;
import com.mju.IdolIns.data.dto.customerdto.CustomerResponseDto;
import com.mju.IdolIns.data.entity.Customer;
import com.mju.IdolIns.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDAO){
        this.customerDAO = customerDAO;
    }
    @Override
    public CustomerResponseDto getCustomer(int cust_ID) {
        Customer customer = customerDAO.selectCustomer(cust_ID);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setCust_ID(customer.getCustId());
        customerResponseDto.setCust_NM(customer.getCustName());
        customerResponseDto.setSSN(customer.getSSN());
        customerResponseDto.setCust_PN(customer.getCustPN());
        customerResponseDto.setAcc_NM(customer.getAccNum());
        customerResponseDto.setSex(customer.getSex());
        customerResponseDto.setJob(customer.getJob());

        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustName(customerDto.getCust_NM());
        customer.setSSN(customerDto.getSSN());
        customer.setCustPN(customerDto.getCust_PN());
        customer.setAccNum(customerDto.getAcc_NM());
        customer.setSex(customerDto.getSex());
        customer.setJob(customerDto.getJob());

        Customer savedCustomer = customerDAO.insertCustomer(customer);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setCust_ID(savedCustomer.getCustId());
        customerResponseDto.setCust_NM(savedCustomer.getCustName());
        customerResponseDto.setSSN(savedCustomer.getSSN());
        customerResponseDto.setCust_PN(savedCustomer.getCustPN());
        customerResponseDto.setAcc_NM(savedCustomer.getAccNum());
        customerResponseDto.setSex(savedCustomer.getSex());
        customerResponseDto.setJob(savedCustomer.getJob());

        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto changeCustomerName(int cust_ID, String cust_NM) throws Exception {
        Customer changedCustomer = customerDAO.updateCustomerName(cust_ID, cust_NM);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setCust_ID(changedCustomer.getCustId());
        customerResponseDto.setCust_NM(changedCustomer.getCustName());
        customerResponseDto.setSSN(changedCustomer.getSSN());
        customerResponseDto.setCust_PN(changedCustomer.getCustPN());
        customerResponseDto.setAcc_NM(changedCustomer.getAccNum());
        customerResponseDto.setSex(changedCustomer.getSex());
        customerResponseDto.setJob(changedCustomer.getJob());

        return customerResponseDto;
    }

    @Override
    public void deleteCustomer(int cust_ID) throws Exception {
        customerDAO.deleteCustomer(cust_ID);
    }
}
