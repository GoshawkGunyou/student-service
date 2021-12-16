package com.example.studentservice;

import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.service.GradeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceApplicationTests {

    @Autowired
    GradeMapper gradeMapper;

    @Autowired
    GradeService gradeService;

    @Test
    void contextLoads() {
        gradeMapper.findAll().forEach(System.out::println);
    }

    @Test
    void gradeServiceTest() {
        System.out.println(gradeService.getClassInfo(null, 1).getAverages());
        System.out.println(gradeService.getClassInfo("家哇打叔剧", null));

    }

}
