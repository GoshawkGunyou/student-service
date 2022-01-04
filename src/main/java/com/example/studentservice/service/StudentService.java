package com.example.studentservice.service;

import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.response.DataResponse;

import java.util.List;

public interface StudentService {
    DataResponse<List<Student>> findInClass(Integer classId);
    List<Student> findInClass(String className);
    Integer insert(Student student);

    Student findById(Integer id);
    DataResponse<StudentDTO> getInfo(String serial, String name);
}
