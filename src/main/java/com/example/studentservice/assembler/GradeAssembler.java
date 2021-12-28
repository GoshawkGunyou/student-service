package com.example.studentservice.assembler;

import com.example.studentservice.domain.ClassType;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.dto.ClassScoreDTO;
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

    private static List<ClassScoreDTO> buildGradeDTO(Grade grade, Double min, Double max) {
        List<ClassScoreDTO> classScores = new ArrayList<>();
        var val = 0.0;
        if (grade.getMath() != null && (val = grade.getMath()) >= min && val <= max)
            classScores.add(new ClassScoreDTO(ClassType.MATH, val));
        if (grade.getEnglish() != null && (val = grade.getEnglish()) >= min && val <= max)
            classScores.add(new ClassScoreDTO(ClassType.ENGLISH, grade.getEnglish()));
        if (grade.getLanguage() != null && (val = grade.getLanguage()) >= min && val <= max)
            classScores.add(new ClassScoreDTO(ClassType.LANGUAGE, grade.getLanguage()));
        return classScores;
    }
}
