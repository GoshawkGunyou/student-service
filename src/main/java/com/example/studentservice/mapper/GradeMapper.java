package com.example.studentservice.mapper;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.domain.student.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradeMapper {
    List<Grade> findAll();
    List<Grade> findByStudentId(Integer id);
    Grade findByGradeId(Integer id);

    /**
     * finds grade from student id
     * @param id student id to search with
     * @return grade of student matching id
     */
    //Grade findByStudentSerialAndName(Integer id);

    /**
     * version 1 of implementation, takes student and returns grade
     * @param student student info
     * @return grade matching student
     */
    Grade findByStudentSerialAndName(Student student);
    List<Grade> findAllByClassInfo(ClassInfo classInfo);
    Integer update(Grade grade);
    Integer deleteById(Integer id);
}
