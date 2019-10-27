package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.model.Process;
import com.davorin.onboarding.service.FormService;
import com.davorin.onboarding.service.ProcessService;
import com.davorin.onboarding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
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

    @GetMapping("/all")
    public List<Process> getProcess(){
        return processService.getAllProcesses();
    }

    @GetMapping("/user")
    public Process getProcessByUser(@RequestParam Long id){
        return processService.getProcessByUser(id);
    }

    @PostMapping("/new")
    public void newProcess(@RequestBody Process process){
        processService.newProcess(process);
    }


//    TODO dodati mogucnost dodavanja forme na vec postojeci proces
//    @PostMapping("/addform")
//    public void addForm(@RequestBody Form form){
//        processService.addFormToProcess(form);
//    }

}
