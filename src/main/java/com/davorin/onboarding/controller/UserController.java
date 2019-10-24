package com.davorin.onboarding.controller;

import com.davorin.onboarding.service.FormService;
import com.davorin.onboarding.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private ProcessService processService;
    private FormService formService;

    @Autowired
    public UserController(ProcessService processService, FormService formService) {
        this.processService = processService;
        this.formService = formService;
    }

    @GetMapping("")
    public String getProcesses(Model model){
        model.addAttribute("process", processService.getProcessByUser(1000));
        return "index";
    }

}
