package com.mqxu.web.exercise.mapper;

import com.mqxu.web.exercise.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @description: UserMapper
 * @author: mqxu
 * @date: 2022-02-28
 **/
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户对象
     *
     * @param username 用户名
     * @param password 密码
     * @return user
     */
    @Select("SELECT * FROM tb_user WHERE username = #{username} AND password = #{password} ")
    User findUser(@Param("username") String username, @Param("password") String password);


    /**
     * 根据用户名查询用户对象
     *
     * @param username 用户名
     * @return 查询到的用户对象
     */
    @Select("SELECT * FROM tb_user WHERE username = #{username} ")
    User selectByUsername(String username);

    /**
     * 添加用户
     *
     * @param user 用户对象
     */
    @Insert("INSERT INTO tb_user VALUES (null,#{username},#{password}) ")
    void add(User user);
}
