package com.example.studentservice.assembler;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.ScoresDTO;
import com.example.studentservice.dto.StudentDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentAssembler {
    public static StudentDTO create(List<Grade> gradeList, Student student, ClassInfo classInfo) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSerial(student.getSerial());
        studentDTO.setStudentName(student.getName());
        studentDTO.setClassName(classInfo.getName());
        studentDTO.setAddress(student.getAddress());
        // Age = difference of D.O.B to now
        studentDTO.setAge(LocalDate.now().getYear() - student.getDOB().getYear());
        studentDTO.setScores(parseGrades(gradeList));
        return studentDTO;
    }

    private static List<ScoresDTO> parseGrades(List<Grade> grades) {
        List<ScoresDTO> scoresList = new ArrayList<>();
        grades.forEach(grade -> scoresList.add(new ScoresDTO(grade.getLanguage(), grade.getMath(), grade.getEnglish())));
        return scoresList;
    }

    public static String parseIntToSer(Integer id) {
        return String.format("%05d", id);
    }


}
