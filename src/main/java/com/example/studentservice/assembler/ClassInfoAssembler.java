package com.example.studentservice.assembler;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.dto.ClassInfoDTO;

import java.util.List;

public class ClassInfoAssembler {
    public static ClassInfoDTO create(List<Grade> gradeList, ClassInfo classInfo) {
        ClassInfoDTO classInfoDTO = new ClassInfoDTO();;
        // Averages list of Math, English, Language and Total average values in specified order.
        if (gradeList != null) {
            classInfoDTO.setGrades(gradeList);
        }
        classInfoDTO.setClassInfo(classInfo);
        return classInfoDTO;
    }

    public static String parseIntToSer(Integer id) {
        return String.format("%03d", id);
    }


}
