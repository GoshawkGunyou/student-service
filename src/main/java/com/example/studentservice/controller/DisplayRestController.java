package com.example.studentservice.controller;

import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.Query;
import com.example.studentservice.dto.StudentGradeDTO;
import com.example.studentservice.service.ClassInfoService;
import com.example.studentservice.service.GradeService;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisplayRestController {
    @Autowired
    GradeService gradeService;

    @Autowired
    StudentService studentService;

    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping("/display/grade")
    @ResponseBody
    @CrossOrigin
    public StudentGradeDTO toGrade(@RequestBody Query q) {
        System.out.println("looking or grade of: " + q.getStudentName());
        return gradeService.getGradeOf(q.getStudentName(), q.getMin(), q.getMax());
    }

    @RequestMapping("/display/loadStudents")
    @ResponseBody
    @CrossOrigin
    public List<Student> students(@RequestBody Integer classId) {
        System.out.println("attempt to find: " + classId);
        return studentService.findInClass(classId);
    }
}
