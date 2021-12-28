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

    public String printSerial() {
        return this.serial != null ? "SN-" + this.serial : null;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setSerial(Integer id) {
        LocalDate now = LocalDate.now();
        String month = now.getMonth().getValue() > 9 ? "" + now.getMonthValue() : "0" + now.getMonthValue();
        String stringId = String.valueOf(id);
        if (id < 10)
            stringId = "0000" + stringId;
        else if (id < 100)
            stringId = "000" + stringId;
        else if (id < 1000)
            stringId = "00" + stringId;
        else if (id < 10000)
            stringId = "0" + stringId;
        this.serial = String.format("%d-%s-%s", now.getYear(), month, stringId);

    }
}
