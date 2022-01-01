package com.example.studentservice.controller;

import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.ClassInfoDTO;
import com.example.studentservice.form.ClassQuery;
import com.example.studentservice.form.ScoreQuery;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.dto.StudentGradeDTO;
import com.example.studentservice.form.StudentQuery;
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
    public StudentGradeDTO toGrade(@RequestBody ScoreQuery q) {
        return gradeService.getGradeOf(q);
    }

    @RequestMapping("/loadStudents")
    @CrossOrigin
    public List<Student> students(@RequestBody Integer classId) {
        return studentService.findInClass(classId);
    }

    @RequestMapping("/student")
    @CrossOrigin
    public StudentDTO findStudent(@RequestBody StudentQuery studentQuery) {
        if (studentQuery.isNull()) return null;
        studentQuery.clean();
        return studentService.getInfo(studentQuery.getStudentSerial(), studentQuery.getStudentName());
    }

    @RequestMapping("/classInfo")
    @CrossOrigin
    public ClassInfoDTO findClassInfo(@RequestBody ClassQuery classQuery) {
        return classInfoService.getClassInfo(classQuery.getClassName(), classQuery.getClassSerial());
    }


}
