package com.example.studentservice.assembler;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.dto.StudentDTO;

import java.time.LocalDate;

public class StudentAssembler {
    public static StudentDTO parse(Grade grade) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSerial(grade.getStudent().getSerial());
        studentDTO.setName(grade.getStudent().getName());
        studentDTO.setClassName(grade.getStudent().getClassInfo().getName());
        studentDTO.setAddress(grade.getStudent().getAddress());
        // Age = difference of D.O.B to now
        studentDTO.setAge(LocalDate.now().getYear() - grade.getStudent().getDOB().getYear());
        studentDTO.setEnglish(grade.getEnglish());
        studentDTO.setMaths(grade.getMath());
        studentDTO.setLanguage(grade.getLanguage());
        Double[] values = generateValues(grade);
        studentDTO.setTotal(values[0]);
        studentDTO.setAverage(values[1]);
        return studentDTO;
    }

    /**
     * generates sum and average from given grade object
     * @param grade grade object to generate values from
     * @return Double[] with sum at index 0 and average at index 1
     */
    private static Double[] generateValues(Grade grade) {
        double sum = 0.0;
        double count = 0;
        if (grade.getLanguage()!=null) {
            sum += grade.getLanguage();
            count++;
        }
        if (grade.getMath()!=null) {
            sum += grade.getMath();
            count++;
        }
        if (grade.getEnglish()!=null) {
            sum += grade.getEnglish();
            count++;
        }
        double average =  sum / count;
        return new Double[] {sum, average};
    }

}
