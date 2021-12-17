package com.example.studentservice.mapper;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.domain.student.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    List<Grade> findAll();
    List<Grade> findByStudentId(Integer id);
    Grade findByGradeId(Integer id);
    //
    Grade findByStudentIdAndName(Student student);
    List<Grade> findAllByClassInfo(ClassInfo classInfo);
    Integer update(Grade grade);
    Integer deleteById(Integer id);
}
