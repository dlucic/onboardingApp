package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.model.Process;
import com.davorin.onboarding.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {

    private ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService) {
        this.processService = processService;
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

    @PostMapping("/addform")
    public void addForm(@RequestBody Form form, @RequestParam Long processId){
        processService.addFormToProcess(form, processId);
    }

    @DeleteMapping("/delete")
    public void deleteProcess(@RequestParam Long id) {
        processService.deleteProcess(id);
    }
}
