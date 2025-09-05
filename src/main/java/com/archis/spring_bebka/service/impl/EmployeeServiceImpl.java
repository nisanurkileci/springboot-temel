package com.archis.spring_bebka.service.impl;

import com.archis.spring_bebka.model.Employee;
import com.archis.spring_bebka.repository.EmployeeRepository;
import com.archis.spring_bebka.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByNameContaining(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesBySalaryGreaterThan(double amount) {
        return employeeRepository.findBySalaryGreaterThan(amount);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByDepartmentNative(String department) {
        return employeeRepository.findByDepartmentNative(department);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation =  Isolation.READ_COMMITTED,rollbackFor = Exception.class)
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
    @Transactional()
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
