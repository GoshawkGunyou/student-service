package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.StudentAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.mapper.StudentMapper;
import com.example.studentservice.service.StudentService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Mapper
    StudentMapper studentMapper;

    @Mapper
    GradeMapper gradeMapper;

    @Override
    public List<Student> findInClass(Integer classId) {
        return null;
    }

    @Override
    public List<Student> findInClass(String className) {
        return null;
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public StudentDTO getInfo(String serial, String name) {
        StudentDTO studentDTO = null;
        Student student = new Student();
        student.setName(name);
        student.setSerial(serial);
        Grade grade = gradeMapper.findByStudentSerialAndName(student);
        if (grade != null) {
            studentDTO = StudentAssembler.parse(grade);
        }
        return studentDTO;
    }
}
