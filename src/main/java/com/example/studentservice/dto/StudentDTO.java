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
    String serial;
    String name;
    String className;
    String address;
    Integer age;
    // Potentially more than one score per student
    List<ScoresDTO> scores;
}
