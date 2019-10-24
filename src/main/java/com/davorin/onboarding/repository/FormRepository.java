package com.davorin.onboarding.repository;

import com.davorin.onboarding.model.Form;

import java.util.List;

public interface FormRepository {

    List<Form> getAllForms();

    void saveForm(Form form);

    List<Form> getFormsByProcessId(long processId);

    Long getSequence();
}
