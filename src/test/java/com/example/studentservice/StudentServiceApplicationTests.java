package com.example.studentservice;

import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.service.ClassInfoService;
import com.example.studentservice.service.GradeService;
import com.example.studentservice.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceApplicationTests {

    @Autowired
    GradeMapper gradeMapper;

    @Autowired
    GradeService gradeService;

    @Autowired
    ClassInfoService classInfoService;

    @Autowired
    StudentService studentService;

    @Test
    void contextLoads() {
        gradeMapper.findAll().forEach(System.out::println);
    }

    @Test
    void classInfoServiceTest() {
        System.out.println(classInfoService.getClassInfo(null, 1));
        System.out.println(classInfoService.getClassInfo("家哇打叔剧", null));
        System.out.println(classInfoService.getClassInfo(null, 4));

    }

    @Test
    void studentDTOTest() {
        System.out.println(studentService.getInfo(null,"zfl"));
    }

}
