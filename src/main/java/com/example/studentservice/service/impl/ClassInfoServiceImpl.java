package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.ClassInfoAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.dto.ClassInfoDTO;
import com.example.studentservice.mapper.ClassInfoMapper;
import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.response.DataResponse;
import com.example.studentservice.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
    public DataResponse<List<ClassInfo>> findClasses() {
        return new DataResponse<>(classInfoMapper.findAll(), "success");
    }

    /**
     * Finds a single ClassInfo based on given class name or serial. Can be null
     * @param name class name to search with.
     * @param serial class serial to search with.
     * @return ClassInfo if exists in database, otherwise null.
     */
    @Override
    @Deprecated
    public ClassInfo findClass(String name, String serial) {
        if (name == null && serial == null) return null;
        ClassInfo classInfo = new ClassInfo();
        classInfo.setName(name);
        classInfo.setSerial(serial);
        return classInfoMapper.findBy(classInfo);
    }

    /**
     * Finds a class with grade information from className or classSerial (Or both).
     * @param className name of class
     * @param classSerial serial number of class, in non CL- form
     * @return completely filled DataResponse object with ClassInfoDTO stored in dataObject field.
     * If class is not found returns a DataResponse with a null dataObject and error message.
     */
    @Override
    public DataResponse<ClassInfoDTO> getClassInfo(String className, String classSerial) {
        ClassInfoDTO classInfoDTO;
        ClassInfo classInfo = new ClassInfo(null, className, classSerial, null);
        classInfo = classInfoMapper.findBy(classInfo);
        if (classInfo != null) {
            List<Grade> gradeList = gradeMapper.findAllByClassId(classInfo.getId());
            classInfoDTO = ClassInfoAssembler.create(gradeList, classInfo);
            return new DataResponse<>(classInfoDTO, "Success");
        } else {
            return new DataResponse<>(null, "Class not found!");
        }
    }
}
