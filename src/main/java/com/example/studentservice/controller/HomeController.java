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
public class HomeController {
    @Autowired
    ClassInfoService classInfoService;

    @Autowired
    GradeService gradeService;

    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/display/query/class")
    public String toClass(Model model) {
        model.addAttribute("classes", classInfoService.findClasses());
        return "classQuery";
    }

    @RequestMapping("/display/query/grade")
    public String toGradeQuery(Model model) {
        model.addAttribute("classInfos", classInfoService.findClasses());
        return "gradeQuery";
    }

    @RequestMapping("/display/query/student")
    public String toStudentQuery() {
        return "studentQuery";
    }

    @RequestMapping("display/student/grade")
    public String toGrade(Model model, GradeQuery gradeQuery) {
        System.out.println(gradeQuery);
        model.addAttribute("studentGradeDTO", gradeService.getGradeOf(gradeQuery.getStudentName(), gradeQuery.getMin(), gradeQuery.getMax()));
        return "studentGrade";
    }

    @RequestMapping("display/student")
    public String toStudent(Model model, String serial, String name) {
        model.addAttribute("studentInfo", studentService.getInfo(serial, name));
        return "student";
    }
}
