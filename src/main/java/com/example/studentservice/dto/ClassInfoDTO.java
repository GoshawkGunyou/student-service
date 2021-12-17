package com.example.studentservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassInfoDTO {
    Integer classId;
    String className;
    Double languageAvg;
    Double mathAvg;
    Double englishAvg;
    Double totalAvg;
}
