package com.davorin.onboarding.repository.impl;

import com.davorin.onboarding.model.FieldValue;
import com.davorin.onboarding.repository.FieldValueRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FieldValueRepositoryImpl implements FieldValueRepository {

    private JdbcTemplate jdbcTemplate;

    public FieldValueRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFieldValue(FieldValue fieldValue, Long fieldId) {
        String query = "INSERT INTO field_value (value, field_id) VALUES (?, ?)";
        jdbcTemplate.update(query, fieldValue.getValue(), fieldId);
    }

    @Override
    public List<FieldValue> getFieldValueByFieldId(Long fieldId) {
        String query = "select * from field_value where field_id = ?";
            return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(FieldValue.class), fieldId);
    }
}
