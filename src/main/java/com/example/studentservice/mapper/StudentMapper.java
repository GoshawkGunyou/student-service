package com.example.studentservice.mapper;

import com.example.studentservice.domain.student.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();
    List<Student> findAllByClassId(Integer classId);
    List<Student> findAllByClassName(String className);
    Student findByStudent(Student student);
    Student findById(Integer id);
    Integer update(Student student);
    Integer add(Student student);
    Integer deleteById(Integer id);
    String findLast();
}
