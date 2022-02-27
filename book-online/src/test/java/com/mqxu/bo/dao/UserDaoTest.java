package com.mqxu.bo.dao;

import com.mqxu.bo.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: mqxu
 * @date: 2022-02-27
 **/
class UserDaoTest {

    @Test
    void signIn() {
        User user = User.builder()
                .account("mqxu@qq.com")
                .password("111")
                .build();
        User loginUser = new UserDao().signIn(user);
        System.out.println(loginUser);
    }
}