package com.davorin.onboarding.repository.impl;

import com.davorin.onboarding.model.Field;
import com.davorin.onboarding.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FieldRepositoryImpl implements FieldRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FieldRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Field> getAllFields() {
        String query = "SELECT * FROM field";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Field.class));
    }

    @Override
    public void saveField(Field field) {
        String query = "INSERT INTO field (id, label, type) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, field.getId(), field.getLabel(), field.getType());
    }

    @Override
    public Long getFieldSequence() {
//        String query = "select FIELD_SEQ.NEXTVAL from dual";
        String query = "select NEXTVAL('field_seq')";
        return jdbcTemplate.queryForObject(query, new Object[] {}, Long.class);
    }

    @Override
    public List<Field> getFieldsByFormId(Long formId) {
        String query = "SELECT * FROM field f JOIN form_field ff on f.id = ff.field where ff.form = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Field.class), formId);
    }

}
