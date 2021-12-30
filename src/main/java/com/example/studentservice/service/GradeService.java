package com.example.studentservice.service;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.dto.StudentGradeDTO;
import com.example.studentservice.form.ScoreQuery;

public interface GradeService {
    Boolean insert(Grade grade);
    Boolean insert(Integer studentId, Grade grade);

    Boolean delete(Integer gradeId);
    Boolean deleteRecords(Integer studentId);

    Boolean update(Grade grade);

    StudentGradeDTO getGradeOf(ScoreQuery scoreQuery);

}
