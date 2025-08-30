package com.archis.spring_bebka.repository;

import com.archis.spring_bebka.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);

    List<Employee> findByDepartment(String department);

    List<Employee> findByNameAndDepartment(String name, String department);
}