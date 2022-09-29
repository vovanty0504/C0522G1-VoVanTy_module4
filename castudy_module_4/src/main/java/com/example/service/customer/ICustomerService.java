package com.example.service.customer;


import com.example.module.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByAndCustomerNameContains(String name, Pageable pageable);

   void save(Customer customer);
}
