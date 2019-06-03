package org.newit.microservice.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.newit.microservice.model.UserEntity;
import org.newit.microservice.model.UserEntityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisGeneraMapperTest {

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Test
    public void testInsert(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("test from mbg");
        userEntity.setAge(42);
        userEntityMapper.insert(userEntity);

        UserEntityExample example = new UserEntityExample();
        example.createCriteria().andNameLike("from%");
        long count = userEntityMapper.countByExample(example);
        System.out.println("count=" + count);


        UserEntityExample selectExample = new UserEntityExample();
        Calendar instance = Calendar.getInstance();
        instance.set(2019,5,2,15,29,34);

        selectExample.createCriteria().andPasswordIsNull().andCreatedTimeGreaterThan(instance.getTime())
                .andMemoIsNull();
        List<UserEntity> userEntities = userEntityMapper.selectByExample(selectExample);
        userEntities.forEach( u -> System.out.println(u));

    }
}
