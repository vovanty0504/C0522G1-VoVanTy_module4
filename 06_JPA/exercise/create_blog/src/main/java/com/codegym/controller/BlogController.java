package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blogList", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog , RedirectAttributes redirectAttributes) {
//        product.setId((int) (Math.random() * 1000));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","successfully added new!");

        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("blogList", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog) {
        blogService.update( blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id , Model model){
        model.addAttribute("blogList",blogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog);
        redirectAttributes.addFlashAttribute("mess","Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blogList",blogService.findById(id));
        return "view";
    }

    @GetMapping ("/search")
    public String search(@RequestParam String name , Model model){
        model.addAttribute("blogList",blogService.findByNameContains(name));
        return "list";
    }
}
