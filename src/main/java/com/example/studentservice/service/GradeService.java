package com.example.studentservice.service;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.ClassInfoDTO;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.dto.StudentGradeDTO;

public interface GradeService {
    Boolean insert(Grade grade);
    Boolean insert(Integer studentId, Grade grade);

    Boolean delete(Integer gradeId);
    Boolean deleteRecords(Integer studentId);

    Boolean update(Grade grade);

    StudentGradeDTO getGradeOf(String name, String classSerial);

}
