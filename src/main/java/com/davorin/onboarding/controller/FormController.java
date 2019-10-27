package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/form")
public class FormController {

    private FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("/all")
    public List<Form> getForms(){
        return formService.getAllForms();
    }

    @PostMapping("/new")
    public void saveForm(@RequestBody Form form){
        formService.saveForm(form);
    }

    @GetMapping("/process")
    public List<Form> getFormsByProcessId(@RequestParam Long id) {
        return formService.getFormsByProcessId(id);
    }

}