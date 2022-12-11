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
    public Customer updateCustomerName(int custId, String custName) throws CustomException {
        Customer selectedCustomer = Optional.of(customerRepository.getById(custId))
                .orElseThrow(()-> new CustomException(MEMBER_NOT_FOUND));

        Customer updatedCustomer;
        Customer customer = selectedCustomer;
        customer.setCustName(custName);
        updatedCustomer = customerRepository.save(customer);
         return updatedCustomer;
    }

    @Override
    public void deleteCustomer(int custId) throws CustomException {
    Optional<Customer> selectedCustomer = Optional.ofNullable(customerRepository.findById(custId)
            .orElseThrow(() -> new CustomException(MEMBER_NOT_FOUND)));

        Customer customer = selectedCustomer.get();
        customerRepository.delete(customer);
    }
}
