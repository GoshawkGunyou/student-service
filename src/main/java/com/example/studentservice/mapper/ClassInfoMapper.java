package com.example.studentservice.mapper;

import com.example.studentservice.domain.schoolclasses.ClassInfo;

import java.util.List;

public interface ClassInfoMapper {
    List<ClassInfo> findAll();

}
