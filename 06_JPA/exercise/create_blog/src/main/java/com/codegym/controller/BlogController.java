package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/")
    public String search(@PageableDefault(value = 3, sort = "create_day", direction = Sort.Direction.ASC)
                                 Pageable pageable, @RequestParam(defaultValue = "") String name, Model model) {
        model.addAttribute("blogList", blogService.findTitle(name, pageable));
        model.addAttribute("name", name);
        return "blog/index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categoryList", categoryService.finAll());
        model.addAttribute("blogList", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "successfully added new!");
        return "redirect:blog/";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        List<Category> categoryList = categoryService.finAll();
        model.addAttribute("blogList", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.finAll());
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog) {
        blogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blogList", blogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog);
        redirectAttributes.addFlashAttribute("mess", "Removed customer successfully!");
        return "redirect:blog/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogList", blogService.findById(id));
        return "blog/view";
    }


}
