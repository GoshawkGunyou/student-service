package com.example.studentservice.controller;

import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.Query;
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

    @RequestMapping("/display")
    public String toGradeQuery(Model model) {
        model.addAttribute("classInfos", classInfoService.findClasses());
        return "gradeQuery";
    }

    @RequestMapping("display/student")
    public String toGrade(Model model, Query query) {
        System.out.println(query);
        model.addAttribute("studentGradeDTO", gradeService.getGradeOf(query.getStudentName(), query.getMin(), query.getMax()));
        return "studentGrade";
    }
}
