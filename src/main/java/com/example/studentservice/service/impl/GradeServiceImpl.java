package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.GradeAssembler;
import com.example.studentservice.assembler.StudentAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.StudentGradeDTO;
import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.mapper.StudentMapper;
import com.example.studentservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Boolean insert(Grade grade) {
        return null;
    }

    @Override
    public Boolean insert(Integer studentId, Grade grade) {
        return null;
    }

    @Override
    public Boolean delete(Integer gradeId) {
        return null;
    }

    @Override
    public Boolean deleteRecords(Integer studentId) {
        return null;
    }

    @Override
    public Boolean update(Grade grade) {
        return null;
    }

    @Override
    public StudentGradeDTO getGradeOf(String name, Double min, Double max) {
        StudentGradeDTO studentGradeDTO = null;
        Student student = new Student();
        student.setName(name);
        student = studentMapper.findByStudent(student);
        if (student == null) return null;
        Grade grade = gradeMapper.findByStudentSerialAndName(student);
        if (grade != null) {
            studentGradeDTO = GradeAssembler.create(grade, min, max);
        }
        return studentGradeDTO;
    }


}
