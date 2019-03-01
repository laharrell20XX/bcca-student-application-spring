package com.lmd.springbccaappproject.controllers;

import javax.validation.Valid;

import com.lmd.springbccaappproject.models.StudentAppInfo;
import com.lmd.springbccaappproject.repositories.StudentAppRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String saveStudentApp(@Valid StudentAppInfo application, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // something is wrong in the form
            model.addAttribute("errors", errors);
            return "studentAppInfo";
        } else {
            // save the application and return thank you message
            sar.save(application);
            return "thankYouMessage";
        }
    }
}