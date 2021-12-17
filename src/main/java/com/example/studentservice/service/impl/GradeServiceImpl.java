package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.ClassInfoAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.grade.GradeClassAverage;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.ClassInfoDTO;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeMapper gradeMapper;

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





}
