package com.student.repository;

import com.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    List<Student> findBystudFirstName(String name);
}
