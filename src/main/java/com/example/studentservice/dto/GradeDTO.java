package com.example.studentservice.dto;

import com.example.studentservice.domain.ClassType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeDTO {
    ClassType classType;
    Double grade;
}
