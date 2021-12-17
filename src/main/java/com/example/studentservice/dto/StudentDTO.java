package com.example.studentservice.dto;

import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.ClassType;
import com.example.studentservice.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StudentDTO {
    Integer id;
    String name;
    String className;
    String address;
    Integer age;
    Double language;
    Double maths;
    Double english;
    Double total;
    Double average;
}
