package com.example.studentservice.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQuery {
    private String studentName;
    private String studentSerial;

    public void clean() {
        this.strip();
        this.trim();
    }

    public Boolean isNull() {
        return studentName == null && studentSerial == null;
    }

    private void trim() {
        studentName = "".equals(studentName) ? null : studentName;
        studentSerial = "".equals(studentSerial) ? null : studentSerial;
    }

    private void strip() {
        if (studentName != null)
            studentName = studentName.strip();
        if (studentSerial != null)
            studentSerial = studentSerial.strip();
    }
}
