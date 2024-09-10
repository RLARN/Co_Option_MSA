package com.example.userservice.service;


import com.example.userservice.model.userVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class userRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public userVO getUserById(String id) {
        String sql = "SELECT * FROM user WHERE login_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }

    public List<userVO> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper<userVO> {
        @Override
        public userVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            userVO userVO = new userVO();
            userVO.setLogin_id(rs.getString("login_id"));
            //user.setName(rs.getString("name"));
            //user.setEmail(rs.getString("email"));
            return userVO;
        }
    }
}