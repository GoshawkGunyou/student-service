package com.example.studentservice.domain.schoolclasses;

import com.example.studentservice.domain.MetaData;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ClassInfo {
    private Integer id;
    private String serial;
    private String name;
    private ClassStatus status;
    private MetaData metaData;
}
