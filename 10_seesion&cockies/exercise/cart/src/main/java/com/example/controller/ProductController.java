package com.example.controller;


import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@SessionAttributes("cart")
@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public CartDto innitCart() {
        return new CartDto();
    }

    @GetMapping("")
    public String showList(Model model, @CookieValue(value = "product", defaultValue = "-1") int idProduct) {
        if (idProduct != -1) {
            model.addAttribute("history", productService.findById(idProduct).get());
        }
        model.addAttribute("productList", productService.finAll());
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String showProduct(@PathVariable int id, Model model, HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("product", id + "");
        cookie.setMaxAge(60 * 60 * 24 * 10);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        model.addAttribute("product", productService.findById(id).get());
        return "product/detail";
    }

    @GetMapping("/save/{id}")
    public String saveCart(@PathVariable int id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOptional.get(), productDto);
        cartDto.decreaseProduct(productDto);
        return "redirect:/cart";
    }


}
