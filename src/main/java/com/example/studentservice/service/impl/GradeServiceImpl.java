package com.example.studentservice.service.impl;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.grade.GradeClassAverage;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.domain.student.Student;
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
    public Student getStudentInfo(Student student) {
        return null;
    }

    @Override
    public GradeClassAverage getClassInfo(String className, Integer classId) {
        List<Grade> gradeList = gradeMapper.findAll();
        GradeClassAverage gradeClassAverage = new GradeClassAverage();
        gradeClassAverage.setGradeList(gradeList);
        gradeClassAverage.setClassInfo(gradeList.get(0).getStudent().getClassInfo());
        return gradeClassAverage;
    }
}
