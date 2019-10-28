package com.davorin.onboarding.repository;

import java.util.Date;

public interface FormDataRepository {

    void saveDateValue(Long form_id, Date dateValue);

    void saveIntegerValue(Long form_id, Integer integerValue);

    void saveStringValue(Long form_id, String stringValue);
}
