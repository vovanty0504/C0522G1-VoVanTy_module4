package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.module.customer.Customer;
import com.example.module.customer.CustomerType;
import com.example.module.employee.Division;
import com.example.module.employee.EducationDegree;
import com.example.module.employee.Employee;
import com.example.module.employee.Position;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 2) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch, Model model) {
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        Page<Employee> employeeList = employeeService.searchEmployee(nameSearch, addressSearch, phoneSearch, pageable);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto,
                       RedirectAttributes redirectAttributes, Model model) {

        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", employee.getEmployeeName() +
                " thêm mới thành công");
        return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        employeeService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("mess", "xóa khách hàng" +
                employeeService.findById(id).get().getEmployeeName() + "thành công");
        return "redirect:/employee/list";
    }

//    @GetMapping("/edit/{id}")
//    public String showFormEdit(@PathVariable Integer id, Model model) {
//        Customer customer = customerService.findById(id).get();
//        CustomerDto customerDto = new CustomerDto();
//        BeanUtils.copyProperties(customer, customerDto);
//        model.addAttribute("customerType", customerTypeService.findAll());
//        model.addAttribute("customerDto", customerDto);
//        return "customer/edit";
//    }
//
//    @PostMapping("/update")
//    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
//                                 RedirectAttributes redirectAttributes, Model model) {
//        if (bindingResult.hasFieldErrors()) {
//            return "customer/edit";
//        } else {
//            Customer customer = new Customer();
//            BeanUtils.copyProperties(customerDto, customer);
//            customerService.update(customer);
//            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa khách hàng thành công!");
//            return "redirect:/customer/list";
//        }
//    }
}
