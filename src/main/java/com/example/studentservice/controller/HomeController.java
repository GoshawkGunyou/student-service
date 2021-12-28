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

    @RequestMapping("/")
    public String home() {
        return "index";
    }


}
