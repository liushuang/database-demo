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
public class UserJdbcTmplTest {

    @Autowired
    private UserJdbcTmpl userJdbcTmpl;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("from test2");
        user.setPassword("password");
        int insert = userJdbcTmpl.insertUser(user);
        Assert.assertEquals(1, insert);
    }

    @Test
    public void testSelectById(){
        User user = new User();
        user.setName("from test2");
        user.setPassword("password");
        int userReturnId = userJdbcTmpl.insertUserReturnId(user);
        Assert.assertTrue(userReturnId > 0);

        User userFromDB = userJdbcTmpl.selectById(userReturnId);
        Assert.assertEquals("from test2", userFromDB.getName());
    }
}
