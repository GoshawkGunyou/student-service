package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.ClassInfoAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.dto.ClassInfoDTO;
import com.example.studentservice.mapper.ClassInfoMapper;
import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public Boolean insert(ClassInfo classInfo) {

        classInfo.setSerial(parseSerial(classInfoMapper.findLast()) + 1);
        return null;
    }

    private Integer parseSerial(String serial) {
        return Integer.parseInt(serial.substring(serial.length() - 3));
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Integer id, ClassInfo classInfo) {
        return null;
    }

    @Override
    public Boolean update(ClassInfo classInfo) {
        return null;
    }

    @Override
    public List<ClassInfo> findClasses() {
        return classInfoMapper.findAll();
    }

    @Override
    public ClassInfo findClass(String name, String serial) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setName(name);
        classInfo.setSerial(serial);
        return classInfoMapper.findBy(classInfo);
    }

    @Override
    public ClassInfoDTO getClassInfo(String className, String classSerial) {
        ClassInfoDTO classInfoDTO = null;
        ClassInfo classInfo = new ClassInfo();
        if (className != null)
            className = className.strip();
        if (classSerial != null)
            classSerial = classSerial.strip();
        classInfo.setSerial(classSerial);
        classInfo.setName(className);
        classInfo = classInfoMapper.findBy(classInfo);
        if (classInfo != null) {
            List<Grade> gradeList = gradeMapper.findAllByClassId(classInfo.getId());
            classInfoDTO = ClassInfoAssembler.create(gradeList, classInfo);
        }
        return classInfoDTO;
    }
}
