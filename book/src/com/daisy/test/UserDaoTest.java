package com.daisy.test;

import com.daisy.dao.UserDao;
import com.daisy.dao.impl.UserDaoImpl;
import com.daisy.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1234") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }


    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "wzg168", "123456", "wzg168@qq.com")));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin1234") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }
}