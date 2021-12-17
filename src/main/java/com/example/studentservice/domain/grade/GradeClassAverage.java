package com.example.studentservice.domain.grade;

import com.example.studentservice.domain.schoolclasses.ClassInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class GradeClassAverage {
    private ClassInfo classInfo;
    private List<Grade> gradeList;
    private List<Double> averages;

    public ClassInfo getClassInfo() {
        if (classInfo == null) {
            this.classInfo = fetchFirstIfExists();
        }
        return this.classInfo;
    }

    private ClassInfo fetchFirstIfExists() {
        try {
            return gradeList.get(0).getStudent().getClassInfo();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * returns a List of Math, English, Language and Total average values in the specific order.
     */
    public List<Double> getAverages() {
        if (averages == null) {
            doAverage();
        }
        return this.averages;
    }

    /**
     * returns a List of Math, English, Language and Total average values in the specific order.
     */
    private void doAverage() {
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
        this.averages = output;
    }
}
