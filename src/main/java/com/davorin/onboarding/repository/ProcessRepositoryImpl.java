package com.davorin.onboarding.repository;

import com.davorin.onboarding.model.Process;
import com.davorin.onboarding.model.User;
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

    public List<Process> getAllProcesses() {
        String query = "SELECT * FROM process";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Process.class));
    }

    @Override
    public Process getProcessByUser(int userId) {
        String query = "SELECT * FROM process where user_id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Process.class), userId);

    }

    public void saveProcess (Process process) {
        String query = "INSERT INTO process (id, name) VALUES (?, ?)";
        jdbcTemplate.update(query, process.getId(), process.getName());
    }

    public Long getSequence() {
        String query = "select PROCESS_SEQ.NEXTVAL from dual";
        return jdbcTemplate.queryForObject(query, new Object[] {}, Long.class);
    }


}
