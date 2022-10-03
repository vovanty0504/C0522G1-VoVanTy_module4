package com.example.repository.employee;


import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select * from employee where employee_name like %:nameSearch% and " +
            "employee_address like %:addressSearch% and employee_phone_number like %:phoneSearch% and is_delete = false",
            nativeQuery = true)
    Page<Employee> searchEmployee(@Param("nameSearch") String nameSearch,
                                  @Param("addressSearch") String addressSearch,
                                  @Param("phoneSearch") String phoneSearch, Pageable pageable);

    @Modifying
    @Query(value = "update employee set is_delete = true where employee_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}
