package com.allinclusive.springbootdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> getStudent(){
        return studentRepo.findAll();
//        return List.of(new Student(
//                "Lucia",
//                "lucy@gmail.com" ,
//                LocalDate.of(2000, Month.JANUARY, 5)
//
//        ));
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
