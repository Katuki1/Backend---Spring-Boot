package com.microservice.employeeservice.controller;

import com.microservice.employeeservice.model.Employees;
import com.microservice.employeeservice.repository.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping
    public Employees add (@RequestBody Employees employees){
        LOGGER.info("Employee add: {}", employees);
        return employeeRepo.addEmployees(employees);
    }

    @GetMapping
    public List<Employees> findAll(){
        LOGGER.info("Employees find");
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employees findById (@PathVariable Long id){
        LOGGER.info("Employee find: id={}", id);
        return employeeRepo.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employees> findByDepartment(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("Employee find: departmentId={}",departmentId);
        return employeeRepo.findByDepartment(departmentId);
    }
}
