package com.example.studentservice.controller;

import com.example.studentservice.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("display")
public class DisplayController {

    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping("/class")
    public String displayClass(Integer classVar, String className, Model model) {
        System.out.println(classVar);
        model.addAttribute("classInfo", classInfoService.getClassInfo(className, classVar));
        return "classInfo";
    }
}
