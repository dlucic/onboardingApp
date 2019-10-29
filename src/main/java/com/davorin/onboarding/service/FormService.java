package com.davorin.onboarding.service;

import com.davorin.onboarding.model.Field;
import com.davorin.onboarding.model.FieldValue;
import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.repository.FieldRepository;
import com.davorin.onboarding.repository.FieldValueRepository;
import com.davorin.onboarding.repository.FormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    private static final Logger logger = LoggerFactory.getLogger(FormService.class);

    FormRepository formRepository;
    FieldService fieldService;
    FieldRepository fieldRepository;
    FieldValueRepository fieldValueRepository;

    public FormService(FormRepository formRepository, FieldService fieldService, FieldRepository fieldRepository, FieldValueRepository fieldValueRepository) {
        this.formRepository = formRepository;
        this.fieldService = fieldService;
        this.fieldRepository = fieldRepository;
        this.fieldValueRepository = fieldValueRepository;
    }

    public void saveForm(Form form){
        Long formId = formRepository.getSequence();
        form.setId(formId);
        formRepository.saveForm(form);
        List<Field> fields = form.getFields();
        fields.forEach(field -> {
            fieldService.saveField(field, formId);
            fieldService.saveFormField(formId, field.getId());
            field.getFieldValues().forEach(fieldValue ->
                    fieldService.saveFieldValue(fieldValue, field.getId()));
        });
        logger.info("Form " + form.getName() + " saved.");

    }

    public List<Form> getAllForms() {
        List<Form> forms = formRepository.getAllForms();
        this.formSetter(forms);
        return forms;
    }

    public List<Form> getFormsByProcessId(Long processId) {
        List<Form> forms = formRepository.getFormsByProcessId(processId);
        this.formSetter(forms);
        return forms;
    }

    public void formSetter(List<Form> forms){
        forms.forEach(form -> {
            List<Field> fields = fieldRepository.getFieldsByFormId(form.getId());
            form.setFields(fields);
            fields.forEach(field -> {
                List<FieldValue> fieldValues = fieldValueRepository.getFieldValueByFieldId(field.getId());
                field.setFieldValues(fieldValues);
            });
        });
    }

    public void deleteForm(Long id) {
        formRepository.deleteForm(id);
    }
}
