package com.example.springtestfinal.services;


import com.example.springtestfinal.entity.Employee;
import com.example.springtestfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

//    private List<Employee> employees = new ArrayList<Employee>();
@Autowired
EmployeeRepository employeeRepository;

PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Employee> getEmployees() {
      return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        String hashedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(hashedPassword);
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

}
