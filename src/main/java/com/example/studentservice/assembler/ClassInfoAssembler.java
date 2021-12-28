package com.example.studentservice.assembler;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.grade.GradeClassAverage;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.dto.ClassInfoDTO;

import java.util.List;

public class ClassInfoAssembler {
    public static ClassInfoDTO create(GradeClassAverage gradeClassAverage) {
        // Averages list of Math, English, Language and Total average values in specified order.
        List<Double> averages = gradeClassAverage.getAverages();

        ClassInfoDTO classInfoDTO = new ClassInfoDTO();
        classInfoDTO.setClassSerial(gradeClassAverage.getClassInfo().getSerial());
        classInfoDTO.setClassName(gradeClassAverage.getClassInfo().getName());
        classInfoDTO.setMathAvg(averages.get(0));
        classInfoDTO.setEnglishAvg(averages.get(1));
        classInfoDTO.setLanguageAvg(averages.get(2));
        classInfoDTO.setTotalAvg(averages.get(3));
        return classInfoDTO;
    }

    public static ClassInfoDTO parse(ClassInfo classInfo) {
        ClassInfoDTO classInfoDTO = new ClassInfoDTO();
        classInfoDTO.setClassName(classInfo.getName());
        classInfoDTO.setClassSerial(classInfo.getSerial());
        return classInfoDTO;
    }
}
