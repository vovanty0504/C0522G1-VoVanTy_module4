package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String home() {
        return "/home";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "security/myLogin";
    }

    @GetMapping("/403")
    public String showError() {
        return "/security/403";
    }
}


