package com.davorin.onboarding.repository.impl;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.model.FormData;
import com.davorin.onboarding.repository.FormDataRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class FormDataRepositoryImpl implements FormDataRepository {

    private JdbcTemplate jdbcTemplate;

    public FormDataRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveDateValue(Long form_id, Date dateValue) {
        String query = "INSERT INTO formdata (form_id, date_value) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, dateValue);
    }

    @Override
    public void saveNumberValue(Long form_id, Integer integerValue) {
        String query = "INSERT INTO formdata (form_id, number_value) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, integerValue);
    }

    @Override
    public void saveLongTextValue(Long form_id, String stringValue) {
        String query = "INSERT INTO formdata (form_id, long_text) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, stringValue);
    }

    @Override
    public void saveShortTextValue(Long form_id, String stringValue) {
        String query = "INSERT INTO formdata (form_id, short_text) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, stringValue);
    }

    @Override
    public void saveSingleChoiceValue(Long form_id, String stringValue) {
        String query = "INSERT INTO formdata (form_id, single_choice) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, stringValue);
    }

    @Override
    public void saveMultipleChoiceValue(Long form_id, String stringValue) {
        String query = "INSERT INTO formdata (form_id, multiple_choice) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, stringValue);
    }

    @Override
    public void saveYesNoValue(Long form_id, String stringValue) {
        String query = "INSERT INTO formdata (form_id, yes_no) VALUES (?, ?)";
        jdbcTemplate.update(query, form_id, stringValue);
    }

    @Override
    public List<FormData> getAllFormData() {
        String query = "select * from formdata";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(FormData.class));
    }

    @Override
    public FormData getFormDatabyId(Long id) {
        String query = "select * from formdata where form_id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(FormData.class), id);
    }
}
