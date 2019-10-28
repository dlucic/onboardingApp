package com.davorin.onboarding.repository.impl;

import com.davorin.onboarding.repository.FormDataRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class FormDataRepositoryImpl implements FormDataRepository {

    private JdbcTemplate jdbcTemplate;

    public FormDataRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveDateValue(Long form_id, Date dateValue) {
        String query = "INSERT INTO formdata (form_id, value_date) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, dateValue);
    }

    @Override
    public void saveIntegerValue(Long form_id, Integer integerValue) {
        String query = "INSERT INTO formdata (form_id, value_integer) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, integerValue);
    }

    @Override
    public void saveStringValue(Long form_id, String stringValue) {
        String query = "INSERT INTO formdata (form_id, value_string) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, stringValue);
    }
}
