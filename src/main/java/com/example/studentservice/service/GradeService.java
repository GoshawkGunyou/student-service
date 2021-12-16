package com.example.studentservice.service;

import com.example.studentservice.domain.grade.GradeClassAverage;
import com.example.studentservice.domain.student.Student;

public interface GradeService {
    Student getStudentInfo(Student student);
    GradeClassAverage getClassInfo(String className, Integer classId);
}
