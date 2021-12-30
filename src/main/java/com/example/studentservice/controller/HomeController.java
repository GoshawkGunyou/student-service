package com.example.studentservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Deprecated
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }


}
