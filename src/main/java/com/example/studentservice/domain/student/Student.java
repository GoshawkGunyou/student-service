package com.example.studentservice.domain.student;

import com.example.studentservice.domain.MetaData;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class Student {
    private Integer id;
    private String serial;
    private String name;
    private Sex sex;
    private LocalDate dOB;
    private String address;
    private String phone;
    private StudentStatus status;
    private ClassInfo classInfo;
    private MetaData metaData;
}
