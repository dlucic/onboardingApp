package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.Process;
import com.davorin.onboarding.service.FormService;
import com.davorin.onboarding.service.ProcessService;
import com.davorin.onboarding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ProcessController {

    private ProcessService processService;
    private FormService formService;
    private UserService userService;

    @Autowired
    public ProcessController(ProcessService processService, FormService formService, UserService userService) {
        this.processService = processService;
        this.formService = formService;
        this.userService = userService;
    }

    @GetMapping("processes")
    public String getProcesses(Model model){
        model.addAttribute("processes", processService.getAllProcesses());
        return "admin/process";
    }

    @GetMapping("processes/create")
    public String saveProcess(Model model){
        model.addAttribute("processes", processService.getAllProcesses());
        model.addAttribute("selectableForms", formService.getAllForms());
        model.addAttribute("selectableUsers", userService.getAllUsers());
        model.addAttribute("process", new Process());
        return "admin/createprocess";
    }

    @PostMapping("processes/create")
    public String saveProcess(@ModelAttribute("process") Process process){
        processService.createProcess(process);
        return "redirect:/admin/processes";
    }
}
