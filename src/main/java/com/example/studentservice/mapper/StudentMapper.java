package com.example.studentservice.mapper;

import com.example.studentservice.domain.student.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();
    List<Student> findAllByClassId(Integer classId, String className);
    Student findById(Integer id);
    Integer update(Student student);
    Integer add(Student student);
    Integer deleteById(Integer id);
}
