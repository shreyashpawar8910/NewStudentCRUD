package com.student.service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    // ************** for save the students into database *************
    public Student saveStudent(Student student){
        return this.studentRepository.save(student);
    }


    // ************** for get all students from the database *************
    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }


    // ************** for  students by ID from the database *************
    public Student getStudentById(Integer id){
        return this.studentRepository.findById(id).get();
    }

    // ************** for  students by ID from the database *************
    public List<Student> getStudentByName(String name){
        return this.studentRepository.findBystudFirstName(name);
    }


    // ************** for Update data of students into database *************
    public Student updateStudent(Student student, Integer id){
        Student existingStudent = this.studentRepository.findById(id).get();

        existingStudent.setStudFirstName(student.getStudFirstName());
        existingStudent.setStudLastName(student.getStudLastName());
        existingStudent.setStudClass(student.getStudClass());
        existingStudent.setStudDivision(student.getStudDivision());
        existingStudent.setStudMarks(student.getStudMarks());

        return this.studentRepository.save(existingStudent);

    }

    // ************** for delete students from the database *************
    public void deleteStudent(Integer id){
        this.studentRepository.deleteById(id);
    }
}
