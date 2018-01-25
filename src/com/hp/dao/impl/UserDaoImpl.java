package com.hp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hp.dao.UserDao;
import com.hp.po.Asset;
import com.hp.po.User;
import com.hp.util.JdbcUtils;

public class UserDaoImpl implements UserDao {

    public static int userId = 0;
    public static String userName = null;
    @Override
    public Boolean loginIn(User user) {
        final String SQL = "select * from user where userName = ? and userPassword = ?";
        User us = null;
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            Object[] objects = {user.getUserName(),user.getPassword()};
            us = queryRunner.query(SQL, new BeanHandler<>(User.class),objects);
            JdbcUtils.commitTranscation();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                JdbcUtils.rollbackTranscation();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return false;
        }
        
        if (us == null || "".equals(us)) {
            return false;
        }
       userId = us.getUserId();
       userName = us.getUserName();
        return true;
    }

    @Override
    public Boolean registerUser(User user) {
        final String SQL = "insert into user (userName,userPassword,realName,sex,tel,idCard,address)values(?,?,?,?,?,?,?)";
        Object[] objects = {user.getUserName(),user.getPassword(),user.getRealName(),user.getSex(),user.getTel(),user.getIdCard(),user.getAddress()};
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            queryRunner.update(SQL, objects);
            JdbcUtils.commitTranscation();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                JdbcUtils.rollbackTranscation();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override
    public Boolean updatePassword(String oldPassword,String newPassword, int userId) {
        int flag = 0;
        final String SQL = "update user set userPassword = ? where userPassword = ? and userId = ?";
        Object[] objects = {newPassword,oldPassword,userId};
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            flag = queryRunner.update(SQL, objects);
            JdbcUtils.commitTranscation();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                JdbcUtils.rollbackTranscation();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return false;
        }
        if (flag == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean findUserByName(String userName) {
        User user = null;
        final String SQL = "select * from user where userName = ?";
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            user = queryRunner.query(SQL, new BeanHandler<>(User.class),userName);
            JdbcUtils.commitTranscation();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                JdbcUtils.rollbackTranscation();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return false;
        }
        if (user == null || "".equals(user)) {
            return false;
        }
        return true;
    }

}
