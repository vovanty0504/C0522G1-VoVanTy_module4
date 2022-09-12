package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String showList() {
        return "index";
    }

    @GetMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiment", defaultValue = "") String[] arr) {

        if (arr.length == 0) {
            return new ModelAndView("index", "sandwich", "You Have Not Chosen");
        } else {
            return new ModelAndView("index", "sandwich", arr);
        }
    }

}
