package com.example.studentservice.assembler;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.dto.StudentDTO;

import java.time.LocalDate;

public class StudentAssembler {
    public static StudentDTO parse(Grade grade) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(grade.getStudent().getId());
        studentDTO.setName(grade.getStudent().getName());
        studentDTO.setClassName(grade.getStudent().getClassInfo().getName());
        studentDTO.setAddress(grade.getStudent().getAddress());
        // Age = difference of D.O.B to now
        studentDTO.setAge(LocalDate.now().getYear() - grade.getStudent().getDOB().getYear());
        studentDTO.setEnglish(grade.getEnglish());
        studentDTO.setMaths(grade.getMath());
        studentDTO.setLanguage(grade.getLanguage());
        studentDTO.setTotal(grade.getTotal());
        studentDTO.setAverage(grade.getAverage());
        return studentDTO;
    }


}
