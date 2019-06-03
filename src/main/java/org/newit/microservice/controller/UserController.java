package org.newit.microservice.controller;

import org.newit.microservice.dao.UserJdbcTmpl;
import org.newit.microservice.dao.UserMapper;
import org.newit.microservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserJdbcTmpl userJdbcTmpl;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/insertUser")
    @ResponseBody
    public int insertUser(@RequestParam("name")String name){
        User user = new User();
        user.setName(name);
        return userJdbcTmpl.insertUser(user);
    }

    @RequestMapping("/user/{userId}")// localhost:9602/user/1
    @ResponseBody
    public User getUser(@PathVariable("userId") int userId){
        return userJdbcTmpl.selectById(userId);
    }


    @RequestMapping("/getUserByName")
    @ResponseBody
    public User getUserByName(@RequestParam("name") String name){
        return userMapper.selectUserByName(name);
    }
}
