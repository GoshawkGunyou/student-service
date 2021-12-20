package com.example.studentservice.controller;

import com.example.studentservice.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping("/display")
    public String toGradeQuery(Model model) {
        model.addAttribute("classInfos", classInfoService.findClasses());
        return "gradeQuery";
    }
}
