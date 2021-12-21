package com.example.studentservice.service;

import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<Student> findInClass(Integer classId);
    List<Student> findInClass(String className);

    Student findById(Integer id);
    StudentDTO getInfo(String serial, String name);


}
