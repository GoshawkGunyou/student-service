package com.example.studentservice.assembler;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.grade.GradeClassAverage;
import com.example.studentservice.dto.ClassInfoDTO;

import java.util.List;

public class ClassInfoAssembler {
    public static ClassInfoDTO parse(GradeClassAverage grade) {
        // Averages list of Math, English, Language and Total average values in specified order.
        List<Double> averages = grade.getAverages();

        ClassInfoDTO classInfoDTO = new ClassInfoDTO();
        classInfoDTO.setClassId(grade.getClassInfo().getId());
        classInfoDTO.setClassName(grade.getClassInfo().getName());
        classInfoDTO.setMathAvg(averages.get(0));
        classInfoDTO.setEnglishAvg(averages.get(1));
        classInfoDTO.setLanguageAvg(averages.get(2));
        classInfoDTO.setTotalAvg(averages.get(3));
        return classInfoDTO;
    }
}
