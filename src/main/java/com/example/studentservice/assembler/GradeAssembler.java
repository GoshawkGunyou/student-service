package com.example.studentservice.assembler;

import com.example.studentservice.domain.ClassType;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.dto.GradeDTO;

import java.util.ArrayList;
import java.util.List;

public class GradeAssembler {
    public static List<GradeDTO> parse(Grade grade) {
        List<GradeDTO> output = new ArrayList<>();
        String studentName = grade.getStudent().getName();
        String className = grade.getStudent().getClassInfo().getName();
        GradeDTO gradeDTOMath = new GradeDTO(studentName, className, ClassType.MATH,grade.getMath());
        GradeDTO gradeDTOLang = new GradeDTO(studentName, className, ClassType.LANGUAGE,grade.getLanguage());
        GradeDTO gradeDTOEng = new GradeDTO(studentName, className, ClassType.ENGLISH,grade.getEnglish());
        output.add(gradeDTOMath);
        output.add(gradeDTOLang);
        output.add(gradeDTOEng);
        return output;
    }
}
