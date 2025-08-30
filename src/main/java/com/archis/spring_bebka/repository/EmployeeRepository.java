package com.archis.spring_bebka.repository;

import com.archis.spring_bebka.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);

    List<Employee> findByDepartment(String department);

    List<Employee> findByNameAndDepartment(String name, String department);


    @Query("SELECT e FROM Employee e WHERE e.salary > :amount")
    List<Employee> findBySalaryGreaterThan(@Param("amount") double amount);



    @Query(value = "SELECT * FROM employees WHERE department = :dept", nativeQuery = true)
    List<Employee> findByDepartmentNative(String dept);
}