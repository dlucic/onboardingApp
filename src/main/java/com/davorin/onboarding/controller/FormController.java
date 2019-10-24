package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.Field;
import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class FormController {

    private FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("forms")
    public String getForms(Model model){
        model.addAttribute("forms", formService.getAllForms());
        return "admin/forms";
    }

    @GetMapping("forms/create")
    public String fetchAllForms(Model model){
        Form form = new Form();
        model.addAttribute("forms", formService.getAllForms());
        List<Field> fields = new ArrayList<>();
        fields.add(new Field("longText"));
        fields.add(new Field("shortText"));
        fields.add(new Field("date"));
        fields.add(new Field("singleChoice"));
        fields.add(new Field("multipleChoice"));
        fields.add(new Field("number"));
        fields.add(new Field("yesNo"));
        model.addAttribute("selectableFields", fields);
        model.addAttribute("form", form);
        return "admin/createform";
    }

    @PostMapping("forms/create")
    public String createForm(@ModelAttribute("form") Form form, @RequestParam String[] sourceText){
        for (String field : sourceText) {
            if (field.equals("longText")) {
                form.setLongText(true);
            } else if (field.equals("shortText")) {
                form.setShortText(true);
            } else if (field.equals("date")) {
                form.setDate(true);
            } else if (field.equals("singleChoice")) {
                    form.setSingleChoice(true);
            } else if (field.equals("multipleChoice")) {
                form.setMultipleChoice(true);
            } else if (field.equals("number")) {
                form.setNumber(true);
            } else if (field.equals("yesNo")) {
                form.setYesNo(true);
            }
        }
        formService.createForm(form);
        return "redirect:/admin/forms";
    }
}