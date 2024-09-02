package com.telusko.secures.controller;


import com.telusko.secures.model.Student;
import com.telusko.secures.service.MyUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    MyUserDetailsService myUserDetailsService;

    // adding students manually
    private List<Student> students = new ArrayList<Student>(List.of(
            new Student(1, "Navin", 50),
            new Student(2, "kalam", 40)
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;


    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    //csrf token updating like post ..//
    @GetMapping("/cref-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
