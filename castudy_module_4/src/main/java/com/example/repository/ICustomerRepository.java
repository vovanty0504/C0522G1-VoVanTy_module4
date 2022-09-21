package com.example.repository;


import com.example.module.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findByAndCustomerNameContains(String name, Pageable pageable);



}
