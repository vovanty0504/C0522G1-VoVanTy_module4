package com.example.repository.customer;


import com.example.module.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findByAndCustomerNameContains(String name, Pageable pageable);
}
