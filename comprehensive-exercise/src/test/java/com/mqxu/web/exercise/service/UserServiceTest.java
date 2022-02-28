package com.mqxu.web.exercise.service;

import com.mqxu.web.exercise.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: mqxu
 * @date: 2022-02-28
 **/
@Slf4j
class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void login() {
        User user = userService.login("zhangsan", "123");
        assertNotNull(user);
    }

    @Test
    void register() {
        User user = User.builder()
                .username("test")
                .password("111")
                .build();
        boolean flag = userService.register(user);
        assertTrue(flag);
    }
}