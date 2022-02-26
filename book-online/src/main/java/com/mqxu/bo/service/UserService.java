package com.mqxu.bo.service;

import com.mqxu.bo.entity.User;
import com.mqxu.bo.utils.Md5Util;

import java.util.List;

/**
 * 用户业务逻辑类
 *
 * @author mqxu
 * @date 2022/02/27
 **/
public class UserService {
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 用户登陆功能
     *
     * @param account  账号
     * @param password 密码
     * @return user
     */
    public User signIn(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(Md5Util.crypt(password))) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new UserService().signIn("13951905171", Md5Util.crypt("111"));
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("登录失败");
        }
    }
}
