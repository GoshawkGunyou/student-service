package com.example.studentservice.controller;

import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.ClassInfoDTO;
import com.example.studentservice.dto.GradeQuery;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.dto.StudentGradeDTO;
import com.example.studentservice.service.ClassInfoService;
import com.example.studentservice.service.GradeService;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("display")
public class DisplayRestController {
    @Autowired
    GradeService gradeService;

    @Autowired
    StudentService studentService;

    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping("/grade")
    @CrossOrigin
    public StudentGradeDTO toGrade(@RequestBody GradeQuery q) {
        return gradeService.getGradeOf(q.getStudentName(), q.getMin(), q.getMax());
    }

    @RequestMapping("/loadStudents")
    @CrossOrigin
    public List<Student> students(@RequestBody Integer classId) {
        return studentService.findInClass(classId);
    }

    @RequestMapping("/student")
    @CrossOrigin
    public StudentDTO findStudent(@RequestBody String studentName, @RequestBody String studentSerial) {
        return studentService.getInfo(studentSerial, studentName);
    }

    @RequestMapping("/classInfo")
    @CrossOrigin
    public ClassInfoDTO findClassInfo(@RequestBody String className, @RequestBody String classSerial) {
        return classInfoService.getClassInfo(className, classSerial);
    }


}
