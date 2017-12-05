package com.hoomsun.reptile.dao;

import com.hoomsun.reptile.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by bigyoung on 2017/12/1
 */

@Mapper
public interface UserDao {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT * FROM user WHERE age = #{age}")
    List<User> get(int age);

    @Select("INSERT INTO user(name, age) VALUES (#{name}, #{age})")
    void insert(User user);
 
}
