package com.example.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StudentDTO{
    private String serial;
    private String studentName;
    private String address;
    private String className;
    private Integer age;
    // Potentially more than one score per student
    private List<ScoresDTO> scores;
}
