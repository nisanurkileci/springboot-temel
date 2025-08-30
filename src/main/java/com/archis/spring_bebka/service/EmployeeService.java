package com.archis.spring_bebka.service;

import com.archis.spring_bebka.model.Employee;
import com.archis.spring_bebka.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findEmployeesByNameContaining(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    public List<Employee> findEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> findEmployeesBySalaryGreaterThan(double amount) {
        return employeeRepository.findBySalaryGreaterThan(amount);
    }

    public List<Employee> findEmployeesByDepartmentNative(String department) {
        return employeeRepository.findByDepartmentNative(department);
    }

    public Employee update(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setPosition(updatedEmployee.getPosition());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
