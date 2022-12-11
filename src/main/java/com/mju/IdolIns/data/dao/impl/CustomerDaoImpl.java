package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.CustomerDao;
import com.mju.IdolIns.data.entity.Customer;
import com.mju.IdolIns.data.repository.CustomerRepository;
import com.mju.IdolIns.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.MEMBER_NOT_FOUND;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer insertCustomer(Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public Customer selectCustomer(int custId) throws CustomException{
        Customer selectedCustomer = Optional.of(customerRepository.getById(custId))
                .orElseThrow(()->new CustomException(MEMBER_NOT_FOUND));

        System.out.println(selectedCustomer);
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
