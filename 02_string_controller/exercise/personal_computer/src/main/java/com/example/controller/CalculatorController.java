package com.example.controller;

import com.example.service.ICalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculationService calculationService;

    @GetMapping("/")
    public String showCalculator() {
        return "index";
    }

        @RequestMapping("/calculate")
    public ModelAndView calculate(@RequestParam String number1, String number2, String calculation) {
        return new ModelAndView("index", "result", calculationService.result(number1, number2, calculation));
    }
}
