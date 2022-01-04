package com.example.studentservice.service;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.dto.StudentGradeDTO;
import com.example.studentservice.form.ScoreQuery;
import com.example.studentservice.response.DataResponse;

public interface GradeService {
    Boolean insert(Grade grade);
    Boolean insert(Integer studentId, Grade grade);

    Boolean delete(Integer gradeId);
    Boolean deleteRecords(Integer studentId);

    Boolean update(Grade grade);

    DataResponse<StudentGradeDTO> getGradeOf(ScoreQuery scoreQuery);

}
