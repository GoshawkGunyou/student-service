package com.example.studentservice.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreQuery {
    String studentName;
    Double min;
    Double max;

    public Boolean isNull() {
        if (studentName == null)
            return true;
        return min == null && max == null;
    }

    public void clean() {
        swap();
        // lower and upper bounds
        min = min == null || min < 0 ? 0 : min;
        max = max == null || max > 100 ? 100 : max;
        studentName = studentName == null ? null : studentName.strip();
    }

    /**
     * swaps values if wrong way around
     */
    private void swap() {
        if (max < min) {
            var temp = max;
            max = min;
            min = temp;
        }
    }


}
