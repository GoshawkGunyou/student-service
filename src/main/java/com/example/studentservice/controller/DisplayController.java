package com.example.studentservice.controller;

import com.example.studentservice.dto.GradeQuery;
import com.example.studentservice.service.ClassInfoService;
import com.example.studentservice.service.GradeService;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("display")
public class DisplayController {

    @Autowired
    ClassInfoService classInfoService;

    @Autowired
    StudentService studentService;

    @Autowired
    GradeService gradeService;

    @RequestMapping("/class")
    public String displayClass(Integer classVar, String className, Model model) {
        model.addAttribute("classInfo", classInfoService.getClassInfo(className, classVar));
        return "classInfo";
    }

    @RequestMapping("/student")
    public String toStudent(Model model, String studentSerial, String studentName) {
        model.addAttribute("studentInfo", studentService.getInfo(studentSerial, studentName));
        return "student";
    }
    @RequestMapping("/query/class")
    public String toClass(Model model) {
        model.addAttribute("classes", classInfoService.findClasses());
        return "classQuery";
    }

    @RequestMapping("/query/grade")
    public String toGradeQuery(Model model) {
        model.addAttribute("classInfos", classInfoService.findClasses());
        return "gradeQuery";
    }

    @RequestMapping("/query/student")
    public String toStudentQuery() {
        return "studentQuery";
    }

    @RequestMapping("/student/grade")
    public String toGrade(Model model, GradeQuery gradeQuery) {
        model.addAttribute("studentGradeDTO", gradeService.getGradeOf(gradeQuery.getStudentName(), gradeQuery.getMin(), gradeQuery.getMax()));
        return "studentGrade";
    }
}
