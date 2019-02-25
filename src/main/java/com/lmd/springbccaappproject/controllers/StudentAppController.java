package com.lmd.springbccaappproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentAppController {
    @GetMapping("/apply")
    public String showStudentApp() {
        return "studentAppInfo";
    }
}