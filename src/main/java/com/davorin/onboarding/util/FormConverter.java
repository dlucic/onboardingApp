package com.davorin.onboarding.util;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FormConverter implements Converter<String, Form> {

    private FormService formService;

    @Autowired
    public FormConverter(FormService formService) {
        this.formService = formService;
    }

    @Override
    public Form convert(String id) {
        int parsedId = Integer.parseInt(id);
        Form result = formService.getAllForms().stream()
                .filter(form -> form.getId() == parsedId)
                .findFirst()
                .orElse(null);
        return result;
    }
}
