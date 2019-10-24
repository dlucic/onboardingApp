package com.davorin.onboarding.repository;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.model.Process;
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

    public List<Form> getAllForms() {
        String query = "SELECT id, name FROM form";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Form.class));
    }

    public List<Form> getFormsByProcessId(long processId) {
        String query = "SELECT * FROM form f JOIN process_form pf on f.id = pf.form where pf.process = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Form.class), processId);
    }

    public Form getFormById(long formId) {
        String query = "SELECT * FROM form WHERE id = ?";
        return jdbcTemplate.queryForObject(query, Form.class, formId);
    }

    public void saveForm(Form form) {
        String query = "INSERT INTO form (id, name, longtext, shorttext, date, singlechoice, multiplechoice, number, yesno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, form.getId(), form.getName(), form.isLongText(), form.isShortText(), form.isDate(), form.isSingleChoice(), form.isMultipleChoice(), form.isNumber(), form.isYesNo());
    }

    public Long getSequence() {
        String sql = "select FORM_SEQ.NEXTVAL from dual";
        return jdbcTemplate.queryForObject(sql, new Object[] {}, Long.class);
    }
}
