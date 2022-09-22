package com.example.service.impl;

import com.example.module.Customer;
import com.example.repository.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByAndCustomerNameContains(String name, Pageable pageable) {
        return customerRepository.findByAndCustomerNameContains(name,pageable);
    }

    @Override
    public void save(Customer customer) {
      customerRepository.save(customer);
    }
}
