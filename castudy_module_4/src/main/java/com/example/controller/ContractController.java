package com.example.controller;

import com.example.dto.IContractDto;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<IContractDto> contractList = contractService.findAll(pageable);
        model.addAttribute("attachFacilityList", attachFacilityService.findAll());
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("contractList", contractList);
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }

    @PostMapping("/save")
    public String saveContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới hợp đồng thành công!");
        return "redirect:/contract/list";
    }


    @PostMapping("/add-contract-detail")
    public String saveDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công!");
        return "redirect:/contract/list";
    }

    @GetMapping("/{id}")
    public String showAttachFacility(@PathVariable Integer id, Model model) {
        model.addAttribute("contractDetails", contractDetailService.showAll(id));
        return "contract/attach_list";
    }
}
