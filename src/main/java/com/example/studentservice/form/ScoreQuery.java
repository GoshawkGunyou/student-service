package com.example.studentservice.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreQuery {
    private String studentName;
    private Double min;
    private Double max;

    /**
     * Assumes null pointer already checked. Will clean the input and return whether the query object is considered null, based on required fields
     * @return false if student name is null, true otherwise.
     */
    public Boolean isNull() {
        clean();
        return (studentName == null);
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
