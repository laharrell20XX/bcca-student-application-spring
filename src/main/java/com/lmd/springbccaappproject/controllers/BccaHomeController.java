package com.lmd.springbccaappproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BccaHomeController {

    @GetMapping("/")
    public String index() {
        return "bccaHomePage";
    }
}