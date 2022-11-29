package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.CustomerDao;
import com.mju.IdolIns.data.entity.Customer;
import com.mju.IdolIns.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public Customer selectCustomer(int custId) {
        Customer selectedCustomer = customerRepository.getById(custId);
        return selectedCustomer;
    }

    @Override
    public Customer updateCustomerName(int custId, String custName) throws Exception {
        Optional<Customer> selectedCustomer = customerRepository.findById(custId);

        Customer updatedCustomer;
        if(selectedCustomer.isPresent()) {
            Customer customer = selectedCustomer.get();

            customer.setCustName(custName);

            updatedCustomer = customerRepository.save(customer);
        }else {
            throw new Exception();
        }
         return updatedCustomer;
    }

    @Override
    public void deleteCustomer(int custId) throws Exception {
    Optional<Customer> selectedCustomer = customerRepository.findById(custId);

    if(selectedCustomer.isPresent()){
        Customer customer = selectedCustomer.get();
        customerRepository.delete(customer);
    } else {
        throw new Exception();
    }
    }
}
