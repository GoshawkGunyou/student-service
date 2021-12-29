package com.example.studentservice.domain.grade;

import com.example.studentservice.domain.schoolclasses.ClassInfoType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GradeResult {
    String studentName;
    String className;
    ClassInfoType classInfoType;
    Double grade;
}
