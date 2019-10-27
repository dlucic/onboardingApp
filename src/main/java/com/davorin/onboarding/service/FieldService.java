package com.davorin.onboarding.service;

import com.davorin.onboarding.model.Field;
import com.davorin.onboarding.model.FieldValue;
import com.davorin.onboarding.repository.FieldRepository;
import com.davorin.onboarding.repository.FieldValueRepository;
import com.davorin.onboarding.repository.FormFieldRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService {

    private static final Logger logger = LoggerFactory.getLogger(FieldService.class);

    private FieldRepository fieldRepository;
    private FormFieldRepository formFieldRepository;
    private FieldValueRepository fieldValueRepository;

    @Autowired
    public FieldService(FieldRepository fieldRepository, FormFieldRepository formFieldRepository, FieldValueRepository fieldValueRepository) {
        this.fieldRepository = fieldRepository;
        this.formFieldRepository = formFieldRepository;
        this.fieldValueRepository = fieldValueRepository;
    }

    public List<Field> getFieldsByFormId(Long formId){
        List<Field> fields = fieldRepository.getFieldsByFormId(formId);
        fields.forEach(field -> {
            List<FieldValue> fieldValues = fieldValueRepository.getFieldValueByFieldId(field.getId());
            field.setFieldValues(fieldValues);
        });
        return fields;
    }

    public List<Field> getAllFields() {
        List<Field> fields = fieldRepository.getAllFields();
        fields.forEach(field -> {
            List<FieldValue> fieldValues = fieldValueRepository.getFieldValueByFieldId(field.getId());
            field.setFieldValues(fieldValues);
        });
        return fields;
    }

    public void saveField(Field field) {
        Long fieldId = fieldRepository.getFieldSequence();
        field.setId(fieldId);
        fieldRepository.saveField(field);
        logger.info("Field " + field.getLabel() + "saved.");
    }

    public void saveFormField(Long formID, Long fieldId) {
        formFieldRepository.saveFormField(formID, fieldId);
    }

    public void saveFieldValue(FieldValue fieldValue, Long fieldId) {
        fieldValueRepository.saveFieldValue(fieldValue, fieldId);
    }
}
