package com.hp.test;

import org.junit.Test;

import com.hp.dao.UserDao;
import com.hp.dao.impl.UserDaoImpl;
import com.hp.po.User;

public class TestUserDaoImpl {

    @Test
    public void testLoginIn() {
        User user = new User();
        user.setUserName("a");
        user.setPassword("b");
        UserDao userDao = new UserDaoImpl();

        System.out.println(userDao.loginIn(user));
    }

    @Test
    public void testRegisterUser() {

        User user = new User();
        user.setUserName("d");
        user.setPassword("d");
        user.setRealName("d");
        user.setSex("d");
        user.setAddress("d");
        user.setIdCard("d");
        user.setTel("d");
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.registerUser(user));
    }

    @Test
    public void testUpdatePassword() {

        UserDao userDao = new UserDaoImpl();
      //  userDao.updatePassword("a", "b");
    }
}
