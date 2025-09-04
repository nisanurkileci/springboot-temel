package com.archis.spring_bebka.service;

import com.archis.spring_bebka.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    List<Employee> findEmployeesByNameContaining(String name);
    List<Employee> findEmployeesByDepartment(String department);
    List<Employee> findEmployeesBySalaryGreaterThan(double amount);
    List<Employee> findEmployeesByDepartmentNative(String department);
    Employee update(Long id, Employee updatedEmployee);
    void deleteById(Long id);
}
