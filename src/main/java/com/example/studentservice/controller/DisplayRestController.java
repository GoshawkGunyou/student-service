package com.example.studentservice.controller;

import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.GradeQuery;
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
    @ResponseBody
    @CrossOrigin
    public StudentGradeDTO toGrade(@RequestBody GradeQuery q) {
        System.out.println("looking or grade of: " + q.getStudentName());
        return gradeService.getGradeOf(q.getStudentName(), q.getMin(), q.getMax());
    }

    @RequestMapping("/loadStudents")
    @ResponseBody
    @CrossOrigin
    public List<Student> students(@RequestBody Integer classId) {
        System.out.println("attempt to find: " + classId);
        return studentService.findInClass(classId);
    }
}
