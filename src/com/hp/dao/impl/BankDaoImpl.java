package com.hp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.dao.BankDao;
import com.hp.po.Bank;
import com.hp.util.JdbcUtils;

public class BankDaoImpl implements BankDao {

    // 添加银行
    @Override
    public Boolean addBank(Bank bank) {
        final String SQL = "insert into bank(bankName,bankTel)values(?,?)";
        Object[] objects = { bank.getBankName(), bank.getBankTel() };

        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            queryRunner.update(SQL, objects);
            JdbcUtils.commitTranscation();
        } catch (SQLException e) {
           
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

    // 更新银行
    @Override
    public Boolean updateBank(String newBankName,int bankId,String bankTel) {
        final String SQL = "update bank set bankName = ? ,bankTel = ?where bankId = ?";
        Object[] objects = {newBankName,bankTel,bankId};
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

    // 删除银行
    @Override
    public Boolean deleteBank(int bankId) {
        final String SQL = "delete from bank where bankId = ?";
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            queryRunner.update(SQL, bankId);
            JdbcUtils.commitTranscation();
        } catch (SQLException e) {          
            e.printStackTrace();
            try {
                JdbcUtils.rollbackTranscation();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return false;
            }
        }
        return true;
    }

    // 查询所有银行
    @Override
    public List<Bank> findAllBank() {
        final String SQL = "select * from bank";
        List<Bank> list = null;
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            list = queryRunner.query(SQL, new BeanListHandler<>(Bank.class));
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

    //根据银行name查询
    @Override
    public Bank findByName(String bankName) {
        final String SQL = "select * from bank where bankName = ?";
        Bank bank = null;
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            bank = queryRunner.query(SQL, new BeanHandler<>(Bank.class), bankName);
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
        return bank;
    }
  //根据银行id查询
    @Override
    public Bank findById(int bankId) {
        final String SQL = "select * from bank where bankId = ?";
        Bank bank = null;
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            bank = queryRunner.query(SQL, new BeanHandler<>(Bank.class), bankId);
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
        return bank;
    }

}
