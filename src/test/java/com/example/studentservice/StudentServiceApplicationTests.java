package com.example.studentservice;

import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.mapper.ClassInfoMapper;
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
    ClassInfoMapper classInfoMapper;

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
    void classInfoMapperTest() {
//        classInfoMapper.findAll().forEach(System.out::println);
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(1);
        System.out.println(classInfoMapper.findBy(classInfo));
    }

    @Test
    void gradeMapperTest() {
        gradeMapper.findAllByClassId(1).forEach(System.out::println);
    }

    @Test
    void classInfoServiceTest() {
        System.out.println(classInfoService.getClassInfo(null, "2021-08-001"));
        System.out.println(classInfoService.getClassInfo("家哇打叔剧", null));
        System.out.println(classInfoService.getClassInfo(null, "2021-08-002"));
    }

    @Test
    void studentDTOTest() {
        System.out.println(studentService.getInfo(null,"zfl"));
    }

    @Test
    void studentGradeDTOLimits() {
        System.out.println(gradeService.getGradeOf("zfl", 60.0, 100.0));
        System.out.println(gradeService.getGradeOf("zfl", 20.0, 50.0));
    }

}
