package com.example.studentservice.controller;

import com.example.studentservice.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayController {

    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping("/display/class")
    public String displayClass(Integer id, Model model) {
        model.addAttribute("classes", classInfoService.getClassInfo(null, id));
        return "";
    }
}
