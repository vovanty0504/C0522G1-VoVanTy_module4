package com.example.controller;

import com.example.model.MedicalDeclaration;
import com.example.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping("/")
    public String showList(Model model) {
        List<MedicalDeclaration> medicalDeclarationList = medicalDeclarationService.findAll();
        model.addAttribute("medicalDeclarationList", medicalDeclarationList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("travelInformationList",medicalDeclarationService.travelInformation());
        model.addAttribute("gender",medicalDeclarationService.gender());
        model.addAttribute("country",medicalDeclarationService.country());
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        model.addAttribute("departureDay",medicalDeclarationService.departureDay());
        model.addAttribute("departureMonth",medicalDeclarationService.departureMonth());
        model.addAttribute("departureYear",medicalDeclarationService.departureYear());
        model.addAttribute("endDay",medicalDeclarationService.endDay());
        model.addAttribute("endMonth",medicalDeclarationService.endMonth());
        model.addAttribute("endYear",medicalDeclarationService.endYear());
        model.addAttribute("dayOfBirth",medicalDeclarationService.dayOfBirth());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        medicalDeclarationService.save(medicalDeclaration);
        redirectAttributes.addFlashAttribute("mess", "medicalDeclaration" + medicalDeclaration.getName()
                + "Thêm mới thành công!");
        return "redirect:/";
    }

}
