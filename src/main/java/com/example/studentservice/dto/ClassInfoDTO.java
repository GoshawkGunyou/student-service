package com.example.studentservice.dto;

import com.example.studentservice.domain.grade.Grade;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class ClassInfoDTO {
    String classSerial;
    String className;
    Double languageAvg;
    Double mathAvg;
    Double englishAvg;
    Double totalAvg;

    public void setClassSerial(String classSerial) {
        this.classSerial = "CL-" + classSerial;
    }

    public void doAverages(List<Grade> grades) {
        int mathCount = 0;
        int languageCount = 0;
        int englishCount = 0;
        double mathSum = 0.0;
        double languageSum = 0.0;
        double englishSum = 0.0;

        for (Grade grade : grades) {
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
        mathAvg = mathSum / mathCount;
        englishAvg = englishSum / englishCount;
        languageAvg =  languageSum / languageCount;
        totalAvg = (mathSum + languageSum + englishSum) / (mathCount + languageCount + englishCount);
    }
}
