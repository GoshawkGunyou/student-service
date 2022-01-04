package com.example.studentservice.form;

import lombok.Data;

import java.util.Arrays;

@Data
public class ClassQuery {
    private String className;
    private String classSerial;

    /**
     * Checks whether query has null values to search with after cleaning.
     * @return True if both className and classSerial are null, otherwise false.
     */
    public Boolean isNull() {
        clean();
        return className == null && classSerial == null;
    }

    private void clean() {
        className = "".equals(className) || classSerial == null ? null : checkSerial(className.strip());
        classSerial = "".equals(classSerial) || classSerial == null ? null : classSerial.strip();
    }

    /**
     * Checks if serial is valid. A valid serial either begins with CL- and is length of 14 or is 11 characters long and can be split into 3 parts.
     * Does not check for valid alphanum combination, only matching size.
     * @param serial potential serial to check
     * @return serial without CL- or serial itself if valid. Null if serial does not meet requirements.
     */
    private String checkSerial(String serial) {
        if (serial.length() == 14 && "CL-".equals(serial.substring(0, 3))) {
            return serial.substring(3);
        }
        if (serial.length() == 11 && serial.split("-").length == 3) {
            return serial;
        }
        return null;
    }
}
