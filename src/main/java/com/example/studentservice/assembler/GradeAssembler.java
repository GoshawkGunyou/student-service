package com.example.studentservice.assembler;

import com.example.studentservice.domain.ClassType;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.dto.ClassScoreDTO;
import com.example.studentservice.dto.StudentGradeDTO;

import java.util.ArrayList;
import java.util.List;

public class GradeAssembler {
    public static StudentGradeDTO create(Grade grade, Double min, Double max) {
        String studentName = grade.getStudent().getName();
        String className = grade.getStudent().getClassInfo().getName();
        StudentGradeDTO studentGradeDTO = new StudentGradeDTO();
        studentGradeDTO.setStudentName(studentName);
        studentGradeDTO.setClassName(className);
        studentGradeDTO.setGradeDTOs(buildGradeDTO(grade, min, max));
        return studentGradeDTO;
    }

    private static List<ClassScoreDTO> buildGradeDTO(Grade grade, Double min, Double max) {
        List<ClassScoreDTO> classScores = new ArrayList<>();
        Double val;
        if ((val = grade.getMath()) != null && val >= min && val <= max)
            classScores.add(new ClassScoreDTO(ClassType.MATH, val));
        if ((val = grade.getEnglish())!= null && val >= min && val <= max)
            classScores.add(new ClassScoreDTO(ClassType.ENGLISH, val));
        if ((val = grade.getLanguage()) != null && val >= min && val <= max)
            classScores.add(new ClassScoreDTO(ClassType.LANGUAGE, val));
        return classScores;
    }
}
