package com.davorin.onboarding.repository;

import com.davorin.onboarding.model.FormData;

import java.util.Date;
import java.util.List;

public interface FormDataRepository {

    void saveDateValue(Long form_id, Date dateValue);

    void saveNumberValue(Long form_id, Integer integerValue);

    void saveLongTextValue(Long form_id, String stringValue);

    void saveShortTextValue(Long form_id, String stringValue);

    void saveSingleChoiceValue(Long form_id, String stringValue);

    void saveMultipleChoiceValue(Long form_id, String stringValue);

    void saveYesNoValue(Long form_id, String stringValue);

    List<FormData> getAllFormData();

    FormData getFormDatabyId(Long id);
}
