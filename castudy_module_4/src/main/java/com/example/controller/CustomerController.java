package com.example.controller;

import com.example.module.customer.Customer;
import com.example.module.customer.CustomerType;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private
    ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "") String search, @PageableDefault(value = 5) Pageable pageable,
                           Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("search", search);
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/save")
    public String showFormCreate(Model model) {
        model.addAttribute("customerType", customerTypeService.findAll());
        model.addAttribute("customerList", new Customer());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(Customer customer , RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công!");
        return "redirect:/customer/list";
    }
}
