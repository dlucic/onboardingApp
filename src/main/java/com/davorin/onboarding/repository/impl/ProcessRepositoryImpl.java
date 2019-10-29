package com.davorin.onboarding.repository.impl;

import com.davorin.onboarding.model.Process;
import com.davorin.onboarding.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcessRepositoryImpl implements ProcessRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Process> getAllProcesses() {
        String query = "SELECT * FROM process";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Process.class));
    }

    @Override
    public Process getProcessByUser(Long userId) {
        String query = "SELECT * FROM process where user_id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Process.class), userId);
    }

    @Override
    public void saveProcess (Process process) {
        String query = "INSERT INTO process (id, name, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, process.getId(), process.getName(), process.getUserId());
    }

    @Override
    public Long getSequence() {
//        String query = "select PROCESS_SEQ.NEXTVAL from dual";
        String query = "select NEXTVAL('process_seq')";
        return jdbcTemplate.queryForObject(query, new Object[] {}, Long.class);
    }

    @Override
    public void deleteProcess(Long id) {
        String query = "DELETE FROM process WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
