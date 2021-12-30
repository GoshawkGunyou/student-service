package com.example.studentservice.mapper;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.domain.student.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradeMapper {
    /**
     * List of grades belonging to a class
     * @param classId classId to find grades of
     * @return list of grades with no student info
     */
    List<Grade> findAllByClassId(Integer classId);



    List<Grade> findAll();
    List<Grade> findByStudentId(Integer id);
    Grade findByGradeId(Integer id);
    Grade findByStudentSerialAndName(Student student);
    List<Grade> findAllByClassInfo(ClassInfo classInfo);
    Integer update(Grade grade);
    Integer deleteById(Integer id);
}
