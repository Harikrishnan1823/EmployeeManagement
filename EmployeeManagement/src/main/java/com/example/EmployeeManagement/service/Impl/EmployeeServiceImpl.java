package com.example.EmployeeManagement.service.Impl;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> getBy() {
        return repo.findAll();
    }

    @Override
    public void save(Employee employee) {
        repo.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID: " + id));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}

