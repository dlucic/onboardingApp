package com.davorin.onboarding.repository.impl;

import com.davorin.onboarding.repository.FormFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FormFieldRepositoryImpl implements FormFieldRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FormFieldRepositoryImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFormField(long formId, long fieldId) {
        String query = "INSERT INTO form_field (form, field) VALUES (?, ?)";
        jdbcTemplate.update(query, formId, fieldId);
    }


}
