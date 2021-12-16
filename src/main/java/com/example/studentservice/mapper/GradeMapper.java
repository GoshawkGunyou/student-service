package com.example.studentservice.mapper;

import com.example.studentservice.domain.grade.Grade;
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
    Integer update(Grade grade);
    Integer deleteById(Integer id);
}
