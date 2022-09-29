package com.example.service.employee;


import com.example.module.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

}
