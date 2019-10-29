package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.FormData;
import com.davorin.onboarding.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formdata")
public class FormDataController {

    private FormDataService formDataService;

    @Autowired
    public FormDataController(FormDataService formDataService) {
        this.formDataService = formDataService;
    }

    @PostMapping("/add")
    public void saveFormData(@RequestBody FormData formData) {
        formDataService.saveFormData(formData);
    }

    @GetMapping("/form")
    public FormData getFormData(@RequestParam Long id) {
        return formDataService.getFormData(id);
    }
}
