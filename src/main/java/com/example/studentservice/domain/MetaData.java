package com.example.studentservice.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class MetaData {
    String creator;
    LocalDateTime creationTime;
    String lastEditor;
    LocalDateTime lastEdit;
}
