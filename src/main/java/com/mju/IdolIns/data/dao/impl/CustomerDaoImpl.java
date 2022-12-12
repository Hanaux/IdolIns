package com.mju.IdolIns.data.dao.impl;

import com.mju.IdolIns.data.dao.CustomerDao;
import com.mju.IdolIns.data.entity.Customer;
import com.mju.IdolIns.data.repository.CustomerRepository;
import com.mju.IdolIns.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

import static com.mju.IdolIns.exception.ErrorCode.*;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer insertCustomer(Customer customer) throws CustomException{
        Customer savedCustomer = Optional.of(customerRepository.save(customer))
                .orElseThrow(()-> new CustomException(COULD_NOT_SAVE));
        return savedCustomer;
    }

    @Override
    @ExceptionHandler(value = {CustomException.class})
    public Customer selectCustomer(int custId) throws CustomException{
        Customer selectedCustomer = Optional.of(customerRepository.getById(custId))
                .orElseThrow(()->new CustomException(CUST_INFO_NOT_FOUND));


        System.out.println(selectedCustomer);
        return selectedCustomer;
    }

    @Override
    public Customer updateCustomerName(int custId, String custName) throws CustomException {
        Customer selectedCustomer = Optional.of(customerRepository.getById(custId))
                .orElseThrow(()-> new CustomException(DATA_NOT_FOUND));

        Customer updatedCustomer;
        Customer customer = selectedCustomer;
        customer.setCustName(custName);
        updatedCustomer = Optional.of(customerRepository.save(customer))
                .orElseThrow(()-> new CustomException(COULD_NOT_UPDATE));
         return updatedCustomer;
    }

    @Override
    public void deleteCustomer(int custId) throws CustomException {
    Optional<Customer> selectedCustomer = Optional.ofNullable(customerRepository.findById(custId)
            .orElseThrow(() -> new CustomException(DATA_NOT_FOUND)));

        Customer customer = selectedCustomer.get();
        try {
            customerRepository.delete(customer);
        }catch (CustomException e){
            e = new CustomException(COULD_NOT_DELETE);
        }
    }
}
