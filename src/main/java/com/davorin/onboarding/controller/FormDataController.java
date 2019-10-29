package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.FormData;
import com.davorin.onboarding.model.dto.FormDataDTO;
import com.davorin.onboarding.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<FormDataDTO> getFormDataById(@RequestParam Long id) {
        return formDataService.getFormDataById(id);
    }
}
