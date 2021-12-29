package com.example.studentservice.mapper;

import com.example.studentservice.domain.schoolclasses.ClassInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassInfoMapper {
    List<ClassInfo> findAll();
    ClassInfo findBy(ClassInfo classInfo);
    String findLast();

}
