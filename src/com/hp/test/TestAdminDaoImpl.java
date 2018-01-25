package com.hp.test;

import java.util.List;

import org.junit.Test;

import com.hp.dao.AdminDao;
import com.hp.dao.impl.AdminDaoImpl;
import com.hp.po.Admin;
import com.hp.po.User;

public class TestAdminDaoImpl {

    @Test
    public void test() {

        Admin admin = new Admin();
        admin.setAdminName("a");
        admin.setAdminPassword("b");
        AdminDao adminDao = new AdminDaoImpl();

        System.out.println(adminDao.loginIn(admin));
    }

    @Test
    public void testFindAll() {

        AdminDao adminDao = new AdminDaoImpl();
        List<User> list = adminDao.findAllUser();
        for (User user : list) {
            System.out.println(user.toString());
        }
    }
}
