package com.example.service;


import com.example.module.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

}
