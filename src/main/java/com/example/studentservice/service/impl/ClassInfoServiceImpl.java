package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.ClassInfoAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.grade.GradeClassAverage;
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
        return null;
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
    public ClassInfoDTO getClassInfo(String className, Integer classId) {
        ClassInfoDTO classInfoDTO;
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(classId);
        if (className != null) {
            className = className.strip();
        }
        classInfo.setName(className);
        classInfo = classInfoMapper.findBy(classInfo);
        List<Grade> gradeList = gradeMapper.findAllByClassInfo(classInfo);

        if (gradeList != null && gradeList.size() > 0) {
            GradeClassAverage gradeClassAverage = new GradeClassAverage();
            gradeClassAverage.setGradeList(gradeList);
            gradeClassAverage.setClassInfo(gradeList.get(0).getStudent().getClassInfo());
            classInfoDTO = ClassInfoAssembler.create(gradeClassAverage);
        } else {
            classInfoDTO = ClassInfoAssembler.parse(classInfoMapper.findBy(classInfo));
        }
        return classInfoDTO;
    }
}
