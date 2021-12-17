package com.example.studentservice.dto;

import com.example.studentservice.domain.ClassType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    String studentName;
    String className;
    ClassType classType;
    Double grade;
}
