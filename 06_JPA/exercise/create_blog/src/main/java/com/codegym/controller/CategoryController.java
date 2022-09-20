package com.codegym.controller;


import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String showListCategory(Model model){
        model.addAttribute("categoryList",categoryService.finAll());
        return "category/list_category";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categoryList",categoryService.finAll());
        model.addAttribute("category", new Category());
        return "category/create_category";
    }

    @PostMapping("/save/category")
    public String save(Category category , RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","successfully added new!");
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findById(id));
        return "category/edit_category";
    }

    @PostMapping("/edit")
    public String edit(Category category) {
        categoryService.update(category);
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id , Model model){
        model.addAttribute("categoryList",categoryService.findById(id));
        return "category/delete_category";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirectAttributes){
        categoryService.remove(category);
        redirectAttributes.addFlashAttribute("mess","Removed customer successfully!");
        return "redirect:/category/list";
    }


}
