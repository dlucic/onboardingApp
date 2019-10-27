package com.davorin.onboarding.repository.impl;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FormRepositoryImpl implements FormRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FormRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Form> getAllForms() {
        String query = "SELECT id, name FROM form";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Form.class));
    }

    @Override
    public List<Form> getFormsByProcessId(long processId) {
        String query = "SELECT * FROM form f JOIN process_form pf on f.id = pf.form where pf.process = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Form.class), processId);
    }

    @Override
    public void saveForm(Form form) {
        String query = "INSERT INTO form (id, name) VALUES (?, ?)";
        jdbcTemplate.update(query, form.getId(), form.getName());
    }

    @Override
    public Long getSequence() {
//        String query = "select FORM_SEQ.NEXTVAL from dual";
        String query = "select NEXTVAL('form_seq')";
        return jdbcTemplate.queryForObject(query, new Object[] {}, Long.class);
    }
}
