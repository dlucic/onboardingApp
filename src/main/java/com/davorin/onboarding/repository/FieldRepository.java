package com.davorin.onboarding.repository;

import com.davorin.onboarding.model.Field;

import java.util.List;

public interface FieldRepository {

    List<Field> getAllFields();

    void saveField(Field field, Long formId);

    Long getFieldSequence();

//    Field getFieldById(Long id);

    List<Field> getFieldsByFormId(Long id);
}
