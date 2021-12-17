package com.example.studentservice.dto;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.ClassType;
import com.example.studentservice.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResult {
    ClassType classType;
    Grade grade;

    public Student getStudent(){
        return grade.getStudent();
    }
}
