package com.example.studentservice.service;

import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.dto.ClassInfoDTO;
import com.example.studentservice.response.DataResponse;

import java.util.List;

public interface ClassInfoService {
    Boolean insert(ClassInfo classInfo);
    Boolean delete(Integer id);
    Boolean update(Integer id, ClassInfo classInfo);
    Boolean update(ClassInfo classInfo);

    List<ClassInfo> findClasses();
    ClassInfo findClass(String name, String serial);

    DataResponse<ClassInfoDTO> getClassInfo(String className, String classSerial);

}
