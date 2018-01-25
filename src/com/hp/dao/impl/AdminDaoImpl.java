package com.hp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.dao.AdminDao;
import com.hp.po.Admin;
import com.hp.po.Bank;
import com.hp.po.User;
import com.hp.util.JdbcUtils;

public class AdminDaoImpl implements AdminDao {

    public static String adminName = null;
    @Override
    public Boolean loginIn(Admin admin) {

        final String SQL = "select * from admin where adminName = ? and adminPassword=?";
        Admin ad = null;
        Object[] objects = { admin.getAdminName(), admin.getAdminPassword() };
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            ad = queryRunner.query(SQL, new BeanHandler<>(Admin.class), objects);
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

        if ("".equals(ad) || null == ad) {
            return false;
        }
        adminName = ad.getAdminName();
        return true;
    }

    @Override
    public List<User> findAllUser() {
        final String SQL = "select * from user";
        List<User> list = null;

        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            list = queryRunner.query(SQL, new BeanListHandler<>(User.class));
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
        }
        return list;
    }

}
