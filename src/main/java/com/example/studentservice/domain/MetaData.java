package com.example.studentservice.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class MetaData {
    private Integer status;
    private String creator;
    private LocalDateTime creationTime;
    private String lastEditor;
    private LocalDateTime lastEdit;
}
