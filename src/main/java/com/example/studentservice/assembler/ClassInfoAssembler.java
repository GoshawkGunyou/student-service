package com.example.studentservice.assembler;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.dto.ClassInfoDTO;

import java.util.ArrayList;
import java.util.List;

public class ClassInfoAssembler {
    public static ClassInfoDTO create(List<Grade> gradeList, ClassInfo classInfo) {
        ClassInfoDTO classInfoDTO = new ClassInfoDTO();
        // Averages list of Math, English, Language and Total average values in specified order.
        if (gradeList != null) {
            List<Double> averages = doAverages(gradeList);
            classInfoDTO.setMathAvg(averages.get(0));
            classInfoDTO.setEnglishAvg(averages.get(1));
            classInfoDTO.setLanguageAvg(averages.get(2));
            classInfoDTO.setTotalAvg(averages.get(3));
        }
        classInfoDTO.setClassSerial(classInfo.getSerial());
        classInfoDTO.setClassName(classInfo.getName());
        return classInfoDTO;
    }

    private static List<Double> doAverages(List<Grade> gradeList) {
        ArrayList<Double> output = new ArrayList<>(4);
        int mathCount = 0;
        int languageCount = 0;
        int englishCount = 0;
        double mathSum = 0.0;
        double languageSum = 0.0;
        double englishSum = 0.0;

        for (Grade grade : gradeList) {
            Double math;
            Double english;
            Double language;
            if ((math = grade.getMath()) != null) {
                mathSum += math;
                mathCount++;
            }
            if ((english = grade.getEnglish()) != null) {
                englishSum += english;
                englishCount++;
            }
            if ((language = grade.getLanguage()) != null) {
                languageSum += language;
                languageCount++;
            }
        }
        output.add(0, mathSum / mathCount);
        output.add(1, englishSum / englishCount);
        output.add(2, languageSum / languageCount);
        output.add(3, (mathSum + languageSum + englishSum) / (mathCount + languageCount + englishCount));
        return output;
    }
}
