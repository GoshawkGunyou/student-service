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

    private void clean() {
        studentName = "".equals(studentName) || studentName == null ? null : studentName.strip();
        studentSerial = "".equals(studentSerial) || studentSerial == null ? null : checkSerial(studentSerial.strip());
    }

    public Boolean isNull() {
        clean();
        return studentName == null && studentSerial == null;
    }

    /**
     * Checks if serial is valid. A valid serial either begins with SN- and is length of 16 or is 13 characters long and
     * can be split into 3 parts.
     * Does not check for valid alphanum combination, only matching size.
     * @param serial potential serial to check
     * @return serial without SN- or serial itself if valid. Null if serial does not meet requirements.
     */
    private String checkSerial(String serial) {
        if (serial.length() == 16 && "SN-".equals(serial.substring(0, 3))) {
            return serial.substring(3);
        }
        if (serial.length() == 13 && serial.split("-").length == 3) {
            return serial;
        }
        return null;
    }
}
