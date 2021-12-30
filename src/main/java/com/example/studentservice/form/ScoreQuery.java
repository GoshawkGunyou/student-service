package com.example.studentservice.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreQuery {
    String studentName;
    Double min;
    Double max;
}
