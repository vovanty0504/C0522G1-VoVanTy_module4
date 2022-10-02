package com.example.service.employee;


import com.example.module.customer.Customer;
import com.example.module.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {

    Page<Employee> searchEmployee(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);

    void save(Employee employee);

    Optional<Employee> findById(Integer id);

    void deleteLogical(Integer id);

    void update(Employee employee);


}
