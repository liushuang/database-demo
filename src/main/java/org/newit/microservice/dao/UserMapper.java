package org.newit.microservice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.newit.microservice.model.User;

@Mapper
public interface UserMapper {
    int insertUser(User user);

    User selectUserById(int userId);

    User selectUserByName(@Param("name")String name);
}
