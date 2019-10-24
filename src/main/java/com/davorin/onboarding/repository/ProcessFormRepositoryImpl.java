package com.davorin.onboarding.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessFormRepositoryImpl implements ProcessFormRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessFormRepositoryImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveProcessForm(long processId, long formId) {
        String query = "INSERT INTO process_form (process, form) VALUES (?, ?)";
        jdbcTemplate.update(query, processId, formId);
    }



}
