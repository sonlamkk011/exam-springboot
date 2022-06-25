package com.example.examspringboot1.service;

import com.example.examspringboot1.entity.Employee;
import com.example.examspringboot1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.examspringboot1.entity.Employee;
import com.example.examspringboot1.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {return employeeRepository.save(employee);
    }
}
