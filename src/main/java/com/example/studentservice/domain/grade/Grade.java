package com.example.studentservice.domain.grade;


import com.example.studentservice.domain.MetaData;
import com.example.studentservice.domain.student.Student;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Grade {
    private Integer id;
    private Student student;
    private Double language;
    private Double math;
    private Double english;
    private MetaData metaData;
    private int count;
    private Double total;
}
