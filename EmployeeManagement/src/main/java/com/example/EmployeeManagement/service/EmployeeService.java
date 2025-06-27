package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getBy();
    void save(Employee employee);
    Employee getById(Long id);
    void deleteById(Long id);
}
