package com.hp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.dao.AssetDao;
import com.hp.po.Asset;
import com.hp.po.Asset1;
import com.hp.po.User;
import com.hp.util.JdbcUtils;

public class AssetDaoImpl implements AssetDao {

    /*
     * 
     * SELECT
    `user`.userName,
    bank.bankId,
    bank.bankName,
    asset.cardNum,
    asset.cardMoney
FROM
    `user`,
    bank,
    asset
WHERE
    asset.bankId = bank.bankId
AND asset.userId = `user`.userId AND `user`.userId = '1'
     */
    
    
    // 查看财产
    @Override
    public List<Asset1> findAsset(int userId) {
        final String SQL = "SELECT`user`.userName,bank.bankId,bank.bankName,asset.cardNum,asset.cardMoney FROM `user`,bank,asset WHERE asset.bankId = bank.bankId AND asset.userId = `user`.userId AND `user`.userId = ?";
        List<Asset1> list = null;
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            list = queryRunner.query(SQL, new BeanListHandler<>(Asset1.class), userId);
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

    //添加账户
    @Override
    public Boolean addAsset(Asset asset) {
        final String SQL = "insert into asset(bankId,cardNum,cardMoney,createDate,userId)values(?,?,?,?,?)";
        Object[] objects = { asset.getBankId(),asset.getCardNum(), asset.getCardMoney(), asset.getCardDate(), asset.getUserId() };
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
    
    //删除账户

    @Override
    public Boolean deleteAssert(int bankId, int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    //查询所有财产
    @Override
    public double findAll(int userId) {
        final String SQL = "select SUM(cardMoney) as sum from asset where userId = ?";
        double money = 0;
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
           Object[] objects = queryRunner.query(SQL, userId, new  ArrayHandler());
           money = (double) objects[0];
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
        
        return money;
    }

    @Override
    public Boolean updateAsser(Asset asset) {
        int flag = 0;
        final String SQL = "update asset set cardMoney = cardMoney + ? where bankId = ? and userId =? and cardNum = ?";
        Object[] objects = {asset.getCardMoney(),asset.getBankId(),asset.getUserId(),asset.getCardNum()};
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
    public Boolean reduceAsset(Asset asset) {
        final String SQL = "update asset set cardMoney = cardMoney - ? where bankId = ? and userId =? and cardNum = ?";
        Object[] objects = {asset.getCardMoney(),asset.getBankId(),asset.getUserId(),asset.getCardNum()};
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
    
    public double chakan(Asset asset) {
        final String SQL = "select * from asset where bankId = ? and userId =? and cardNum = ?";
        Object[] objects = {asset.getBankId(),asset.getUserId(),asset.getCardNum()};
        try {
            JdbcUtils.beginTranscation();
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            Asset asset2 = queryRunner.query(SQL, objects, new BeanHandler<>(Asset.class));
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
        return asset.getCardMoney();
    }

}
