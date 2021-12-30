package com.example.studentservice.domain.schoolclasses;

import com.example.studentservice.assembler.ClassInfoAssembler;
import com.example.studentservice.domain.MetaData;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ClassInfo {
    private Integer id;
    private String serial;
    private String name;
    private MetaData metaData;

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setSerial(Integer id) {
        LocalDate now = LocalDate.now();
        String stringId = ClassInfoAssembler.parseIntToSer(id);
        String month = String.format("%02d", LocalDate.now().getMonthValue());
        this.serial = now.getYear() + "-" + month + "-" + stringId;
    }
}
