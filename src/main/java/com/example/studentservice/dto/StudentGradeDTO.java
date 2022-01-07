package com.example.studentservice.dto;

import com.example.studentservice.domain.ClassType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradeDTO {
    private String studentName;
    private String className;
    private List<ClassScoreDTO> gradeDTOs;
    private ClassType[] classTypes = ClassType.values();
}
