package org.newit.microservice.dao;

import org.newit.microservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Map;

@Repository
public class UserJdbcTmpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertUser(User user){
        return jdbcTemplate.update("insert into user(name, created_time) values(?, now())", user.getName());
    }

    public User selectById(int id){
        Map<String, Object> resultMap = jdbcTemplate.queryForMap("select id, name, created_time from user where id = " + id);
        User user = new User();
        user.setId((Integer) resultMap.get("id"));
        user.setName((String) resultMap.get("name"));
        user.setCreatedTime((Date) resultMap.get("created_time"));
        return user;
    }
}
