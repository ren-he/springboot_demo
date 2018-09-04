package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(Integer userId, String userName, Integer age) {
        jdbcTemplate.update("insert into USER(user_id, user_name, age) values(?, ?, ?)",
                userId, userName, age);
    }

    @Override
    public void deleteUserById(Integer userId) {
        jdbcTemplate.update("delete from USER where user_id = ?",
                userId);
    }

    @Override
    public Integer getUserCount() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
