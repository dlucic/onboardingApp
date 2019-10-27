package com.davorin.onboarding.repository;

import com.davorin.onboarding.model.FieldValue;

import java.util.List;

public interface FieldValueRepository {

    void saveFieldValue(FieldValue fieldValue, Long fieldId);

    List<FieldValue> getFieldValueByFieldId(Long fieldId);
}
