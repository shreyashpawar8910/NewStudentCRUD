package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

        // *** Save Students into database ***
    @PostMapping("/saveStudent")
    public Student addStudent(@RequestBody Student student){
        return this.studentService.saveStudent(student);
    }

        // *** Get all Students from the database ***
    @GetMapping("/getALlStudents")
    public List<Student> getALlStudents(){
        return this.studentService.getAllStudents();
    }

        // *** Update Students into database ***
    @PostMapping("/updateStudent/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id){
        return this.studentService.updateStudent(student,id);
    }

        // *** Get Student by ID ***
    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return this.studentService.getStudentById(id);
    }

        // *** Get Student By Name ***
    @GetMapping("/getStudentByName/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return this.studentService.getStudentByName(name);
    }

        // *** Delete Student By Id ***
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Integer id){
        this.studentService.deleteStudent(id);
    }

}
