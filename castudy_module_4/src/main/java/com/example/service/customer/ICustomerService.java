package com.example.service.customer;


import com.example.module.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ICustomerService {

    Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);

   void save(Customer customer);

   Optional<Customer> findById(Integer id);

   void deleteLogical(Integer id);

   void update(Customer customer);
}
