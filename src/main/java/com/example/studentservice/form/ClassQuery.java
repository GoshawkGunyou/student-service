package com.example.studentservice.form;

import lombok.Data;

@Data
public class ClassQuery {
    private String className;
    private String classSerial;

    public Boolean isNull() {
        clean();
        return className == null && classSerial == null;
    }

    private void clean() {
        className = "".equals(className) || classSerial == null ? null : className.strip();
        classSerial = "".equals(classSerial) || classSerial == null ? null : classSerial.strip();
    }
}
