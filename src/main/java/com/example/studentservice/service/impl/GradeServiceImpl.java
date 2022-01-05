package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.GradeAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.StudentGradeDTO;
import com.example.studentservice.form.ScoreQuery;
import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.mapper.StudentMapper;
import com.example.studentservice.response.DataResponse;
import com.example.studentservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
    public DataResponse<StudentGradeDTO> getGradeOf(ScoreQuery scoreQuery) {
        DataResponse<StudentGradeDTO> response = new DataResponse();
        Student student = new Student();
        student.setName(scoreQuery.getStudentName());
        student = studentMapper.findByStudent(student);
        if (student == null) {
            response.setMessage("Student not found");
            return response;
        }
        Grade grade = gradeMapper.findByStudentSerialAndName(student);
        if (grade != null) {
            response.setDataObject(GradeAssembler.create(grade, scoreQuery.getMin(), scoreQuery.getMax()));
            response.setMessage("Success");
        }
        return response;
    }


}
