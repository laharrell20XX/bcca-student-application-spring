package com.lmd.springbccaappproject.controllers;

import com.lmd.springbccaappproject.repositories.StudentAppRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    StudentAppRepository repository;

    @Autowired
    public AdminController(StudentAppRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/admin")
    public String showAdminHome(Model model) {
        model.addAttribute("applicants", repository.findAll());
        return "adminHome";
    }
}