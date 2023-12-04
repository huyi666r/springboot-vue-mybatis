package com.jiuyu.springboot.mapper;

import com.jiuyu.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * from sys_user")
    List<User> findAll();


    @Insert("INSERT into sys_user(username,password,nickname,email,phone,address) VALUES (#{username},#{password}," +
            "#{nickname},#{email},#{phone},#{address})")
    int insert(User user);


    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("SELECT * FROM  sys_user where username like #{username} limit #{pageNum}, #{pageSize}")
    List<User> selectPage(@Param("pageNum")  Integer pageNum, @Param("pageSize") Integer pageSize, @Param("username") String username);

    @Select("SELECT count(*) from sys_user where username like #{username}")
    Integer selectTotal(@Param("username") String username);
}
