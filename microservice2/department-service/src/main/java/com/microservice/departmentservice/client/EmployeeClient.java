package com.microservice.departmentservice.client;

import com.microservice.departmentservice.model.Employees;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetMapping("/employee/department/{departmentId}")
    public List<Employees> findByDepartment(@PathVariable("departmentId") Long departmentId);

    }
