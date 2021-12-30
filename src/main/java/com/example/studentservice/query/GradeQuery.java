package com.example.studentservice.query;

import lombok.Data;

@Data
public class GradeQuery {
    Double min;
    Double max;
    String studentName;
}
