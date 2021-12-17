package com.example.studentservice.dto;

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
