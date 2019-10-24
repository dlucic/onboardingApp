package com.davorin.onboarding.service;

import com.davorin.onboarding.model.Field;
import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.repository.FormFieldRepository;
import com.davorin.onboarding.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    FormRepository formRepository;

    @Autowired
    FormFieldRepository formFieldRepository;

    public void createForm(Form form){
        form.setId(formRepository.getSequence());
//        form.setName(form.getName());
//        List<Field> fields = form.getFields();
//        fields.forEach(field -> formFieldRepository.saveFormField(form.getId(), field.getId()));
        formRepository.saveForm(form);
    }

    public List<Form> getAllForms() {
        return formRepository.getAllForms();
    }
}
