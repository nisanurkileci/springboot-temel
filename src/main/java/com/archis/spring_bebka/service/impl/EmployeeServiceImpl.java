package com.archis.spring_bebka.service.impl;

import com.archis.spring_bebka.model.Employee;
import com.archis.spring_bebka.repository.EmployeeRepository;
import com.archis.spring_bebka.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findEmployeesByNameContaining(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    @Override
    public List<Employee> findEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public List<Employee> findEmployeesBySalaryGreaterThan(double amount) {
        return employeeRepository.findBySalaryGreaterThan(amount);
    }

    @Override
    public List<Employee> findEmployeesByDepartmentNative(String department) {
        return employeeRepository.findByDepartmentNative(department);
    }

    @Override
    public Employee update(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setPosition(updatedEmployee.getPosition());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
