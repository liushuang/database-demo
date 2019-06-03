package org.newit.microservice.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.newit.microservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("test insert from mybatis");
        int insert = userMapper.insertUser(user);
        Assert.assertTrue(insert > 0 );
    }

    @Test
    public void testSelectById(){
        User user = new User();
        user.setName("from test3");
        user.setPassword("password");
        userMapper.insertUser(user);
        Assert.assertTrue(user.getId() > 0);

        User userFromDB = userMapper.selectUserById(user.getId());
        Assert.assertEquals("from test3", userFromDB.getName());
        Assert.assertEquals("password", userFromDB.getPassword());
    }
}
