package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.Field;
import com.davorin.onboarding.service.FieldService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field")
public class FieldController {

    private static final Logger logger = Logger.getLogger(FieldController.class);

    private FieldService fieldService;

    @Autowired
    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping("/all")
    public List<Field> getAllFields() {
        return fieldService.getAllFields();
    }

    @GetMapping("/form")
    public List<Field> getFieldsByFormId(@RequestParam Long id) {
        return fieldService.getFieldsByFormId(id);
    }

    @PostMapping("/add")
    public void saveField(@RequestBody Field field){
        fieldService.saveField(field);
    }

}
