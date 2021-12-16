package com.example.studentservice.mapper;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradeMapper {
    List<Grade> findAll();
    List<Grade> findByStudentId(Integer id);
    Grade findByGradeId(Integer id);
    //
    Grade findByStudentIdAndName(@Param("id") Integer id,@Param("name") String name);
    List<Grade> findAllByClassInfo(ClassInfo classInfo);
    Integer update(Grade grade);
    Integer deleteById(Integer id);
}
