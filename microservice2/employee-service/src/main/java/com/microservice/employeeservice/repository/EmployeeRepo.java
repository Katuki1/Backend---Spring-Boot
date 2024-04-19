package com.microservice.employeeservice.repository;

import com.microservice.employeeservice.model.Employees;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepo {
    private List<Employees> employeesList = new ArrayList<>();

    public Employees addEmployees (Employees employees){
        employeesList.add(employees);
        return employees;
    }

    public Employees findById(Long id){
        return employeesList.stream()
                .filter(employees -> employees.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employees> findAll(){
        return employeesList;
    }
    public List<Employees> findByDepartment (Long departmentId){
        return employeesList.stream()
                .filter(employees -> employees.departmentId().equals(departmentId))
                .toList();
    }
}
