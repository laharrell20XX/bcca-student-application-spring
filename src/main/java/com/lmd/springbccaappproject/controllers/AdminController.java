package com.lmd.springbccaappproject.controllers;

import com.lmd.springbccaappproject.models.StudentAppInfo;
import com.lmd.springbccaappproject.repositories.StudentAppRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    StudentAppRepository repository;

    @Autowired
    public AdminController(StudentAppRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/admin/home")
    public String showAdminHome(Model model) {
        model.addAttribute("applicants", repository.findAll());
        return "adminHome";
    }

    @GetMapping("/applications/{id}")
    public String detail(Model model, @PathVariable(value = "id") Integer id) {
        StudentAppInfo application = repository.findById(id);
        model.addAttribute("application", application);
        return "studentApplicationPage";
        // if (story.isPresent()) {
        // model.addAttribute("story", story.get());
        // return "story";
        // } else {
        // return "404";
        // }
    }

    @GetMapping("/applications/school/{high_school}")
    public String sortByHighSchool(Model model, @PathVariable(value = "high_school") String highSchool) {
        model.addAttribute("applicants", repository.findBySchool(highSchool));
        return "studentHighSchoolPage";
    }
}