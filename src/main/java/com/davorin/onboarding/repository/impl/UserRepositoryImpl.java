package com.davorin.onboarding.repository.impl;

import com.davorin.onboarding.model.User;
import com.davorin.onboarding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM user";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void addUser(User user) {
        String query = "INSERT INTO user (name) values (?)";
        jdbcTemplate.update(query, user.getName());
    }

    @Override
    public void removeUser(Long id) {
        String query = "DELETE FROM user where id = ?";
        jdbcTemplate.update(query, id);
    }
}
