package com.lmd.springbccaappproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentHomeController {
    @GetMapping("/")
    public String showStudentHome() {
        return "studentHome";
    }
}