package com.example.studentservice.dto;

import lombok.Data;

@Data
public class ScoresDTO {
    Double language;
    Double math;
    Double english;
    Double total;
    Double average;

    public ScoresDTO(Double language, Double math, Double english) {
        this.language = language;
        this.math = math;
        this.english = english;
        generateValues();
    }

    /**
     * generates sum and average from given grade object
     */
    private void generateValues() {
        double sum = 0.0;
        double count = 0;
        if (language!=null) {
            sum += language;
            count++;
        }
        if (math!=null) {
            sum += math;
            count++;
        }
        if (english!=null) {
            sum += english;
            count++;
        }
        average =  sum / count;
        total = sum;
    }
}
