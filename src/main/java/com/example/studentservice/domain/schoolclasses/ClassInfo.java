package com.example.studentservice.domain.schoolclasses;

import com.example.studentservice.domain.MetaData;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ClassInfo {
    private Integer id;
    private String serial;
    private String name;
    private ClassStatus status;
    private MetaData metaData;
}
