package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch, Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Page<Customer> customers = customerService.searchCustomer(nameSearch, addressSearch, phoneSearch, pageable);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customerList", customers);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customerType", customerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypes = customerTypeService.findAll();
            model.addAttribute("customerType", customerTypes);
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("mess", customer.getCustomerName() +
                    " Thêm Mới Thành Công!");
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        customerService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa Khách Hàng" +
                customerService.findById(id).get().getCustomerName() + "  Thành Công!");
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEditCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customerType", customerTypeService.findAll());
        model.addAttribute("customerDto", customerService.findById(id).get());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypes = customerTypeService.findAll();
            model.addAttribute("customerType", customerTypes);
            return "customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.update(customer);
            redirectAttributes.addFlashAttribute("mess", "Chỉnh Sửa Khách Hàng" +
                    customer.getCustomerName() + " Thành Công!");
            return "redirect:/customer/list";
        }
    }

}
