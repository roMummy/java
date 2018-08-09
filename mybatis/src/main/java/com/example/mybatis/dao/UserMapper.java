package com.example.mybatis.dao;

import java.util.List;

import com.example.mybatis.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    List<User> findByName(String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    void insert(@Param("name") String name, @Param("age") Integer age);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    void deleteById(Integer id);

    @SelectProvider(type = UserSqlBuilder.class,  method = "buildGetUsersById")
    List<User> findByIds(Integer id);
}
