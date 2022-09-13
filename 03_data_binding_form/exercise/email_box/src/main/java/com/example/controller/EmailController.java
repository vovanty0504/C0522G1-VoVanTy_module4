package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Email> emailList = emailService.findAll();
        model.addAttribute("emailList", emailList);
        return "list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        model.addAttribute("language", emailService.languages());
        model.addAttribute("pageSize", emailService.pageSize());
        model.addAttribute("email", emailService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        emailService.update(email);
        redirectAttributes.addFlashAttribute("mess", "email" + "Update successful");
        return "redirect:/";
    }


}
