package com.codegym.controller;

import com.codegym.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConversionController {
    @Autowired
    private ICurrencyConversionService currencyConversionService;

    @GetMapping("/")
    public String showList() {
        return "index";
    }

    @GetMapping("/conversion")
    public ModelAndView result(@RequestParam double money) {
        return new ModelAndView("list", "result", currencyConversionService.calculate(money));
    }
}
