package com.example.studentservice.dto;

import com.example.studentservice.domain.ClassType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradeDTO {
    String studentName;
    String className;
    List<GradeDTO> gradeDTOs;
}
