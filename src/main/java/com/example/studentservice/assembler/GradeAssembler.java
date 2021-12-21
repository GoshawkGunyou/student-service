package com.example.studentservice.assembler;

import com.example.studentservice.domain.ClassType;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.dto.GradeDTO;
import com.example.studentservice.dto.StudentGradeDTO;

import java.util.ArrayList;
import java.util.List;

public class GradeAssembler {
    public static StudentGradeDTO buildStudentGrade(Grade grade, Double min, Double max) {
        String studentName = grade.getStudent().getName();
        String className = grade.getStudent().getClassInfo().getName();
        StudentGradeDTO studentGradeDTO = new StudentGradeDTO();
        studentGradeDTO.setStudentName(studentName);
        studentGradeDTO.setClassName(className);
        studentGradeDTO.setGradeDTOs(buildGradeDTO(grade, min, max));
        return studentGradeDTO;
    }

    private static List<GradeDTO> buildGradeDTO(Grade grade, Double min, Double max) {
        List<GradeDTO> gradeDTOS = new ArrayList<>();
        var val = 0.0;
        if ((val = grade.getMath()) >= min && val <= max)
            gradeDTOS.add(new GradeDTO(ClassType.MATH, val));
        if ((val = grade.getEnglish()) >= min && val <= max)
            gradeDTOS.add(new GradeDTO(ClassType.ENGLISH, grade.getEnglish()));
        if ((val = grade.getLanguage()) >= min && val <= max)
            gradeDTOS.add(new GradeDTO(ClassType.LANGUAGE, grade.getLanguage()));
        return gradeDTOS;
    }
}
