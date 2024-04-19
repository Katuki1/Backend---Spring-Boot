package com.microservice.departmentservice.controller;

import com.microservice.departmentservice.model.Department;
import com.microservice.departmentservice.repository.DepartmentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepo departmentRepo;

    @PostMapping
    public Department add (@RequestBody Department department){
      LOGGER.info("Department add: {}", department);
        return departmentRepo.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department find");
        return departmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Department findById (@PathVariable Long id){
        LOGGER.info("Department find: id={}", id);
        return departmentRepo.findById(id);
    }


}
