package com.example.controller;

import com.example.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequestMapping("/cart")
@Controller
public class CartController {

    @GetMapping
    public String showCart(@SessionAttribute(value = "cart", required = false) CartDto cartDto, Model model){
        model.addAttribute("cartDto",cartDto);
        return "cart/list";
    }
}
