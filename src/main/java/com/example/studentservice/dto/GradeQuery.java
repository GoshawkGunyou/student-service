package com.example.studentservice.dto;

import lombok.Data;

@Data
public class GradeQuery {
    Double min;
    Double max;
    String studentName;
}
