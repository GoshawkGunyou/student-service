package com.example.studentservice.assembler;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.dto.ClassInfoDTO;

import java.util.List;

public class ClassInfoAssembler {
    /**
     * Builds a ClassInfoDTO from a java.util.List of grades and ClassInfo. If gradeList is null simply builds classInfo portion.
     * @param gradeList List of grades in class
     * @param classInfo ClassInfo object containing class information.
     * @return ClassInfoDTO with grades if grades are not null, or null grades otherwise.
     */
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
