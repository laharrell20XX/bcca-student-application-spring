package com.lmd.springbccaappproject.controllers;

import com.lmd.springbccaappproject.models.StudentAppInfo;
import com.lmd.springbccaappproject.repositories.StudentAppRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentAppController {
    StudentAppRepository sar;

    @Autowired
    public StudentAppController(StudentAppRepository repository) {
        sar = repository;
    }

    @GetMapping("/apply")
    public String showStudentApp() {
        return "studentAppInfo";
    }

    @PostMapping("/apply")
    public String saveStudentApp(StudentAppInfo application, Model model) {
        sar.save(application);
        return "studentHome";
    }
}