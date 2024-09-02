package com.telusko.secures.repository;

import com.telusko.secures.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepo extends JpaRepository<Student, Integer> {
    public  Student findByName(String name);

}
