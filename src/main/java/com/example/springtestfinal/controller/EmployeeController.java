package com.example.springtestfinal.controller;

import com.example.springtestfinal.entity.Employee;
import com.example.springtestfinal.jwt.JwtUtils;
import com.example.springtestfinal.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private JwtUtils jwtUtils;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> findAllE() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @PostMapping("/sign")
    public ResponseEntity<String> save(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        String jwtToken = jwtUtils.generateTokenFromUsername(createdEmployee);
       return new ResponseEntity<>(jwtToken,HttpStatus.CREATED);
    }

//    @PutMapping("/employee")
//    public ResponseEntity<Void> update(@RequestBody Employee employee) {
//        employeeService.createEmployee(employee);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<String> getJob(@PathVariable Long id) {
        return new ResponseEntity<>(id.toString(), HttpStatus.OK);
    }




}
