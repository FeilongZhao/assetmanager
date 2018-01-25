package com.hp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.hp.dao.AdminDao;
import com.hp.dao.AssetDao;
import com.hp.dao.impl.AdminDaoImpl;
import com.hp.dao.impl.AssetDaoImpl;
import com.hp.po.Asset;
import com.hp.po.User;
import com.mysql.fabric.xmlrpc.base.Data;

public class TestAssetDaoImpl {

    @Test
    public void testFindAll() {

       
    }
    
    @Test
    public void testAddAsset() {
        
        Asset asset = new Asset();
        asset.setCardNum("345");
        asset.setCardMoney(123);
        asset.setCardDate(new Date());
        asset.setUserId(2);
        asset.setBankId(2);
        
        AssetDao assetDao = new AssetDaoImpl();
        assetDao.addAsset(asset);
    }

    @Test
    public void testFindAsset() {
        
        User user = new User();
        user.setUserId(1);
        AssetDao assetDao = new AssetDaoImpl();
       // System.out.println(assetDao.findAll(user));
 
   }
    
    @Test
    public void testAddAsset1() {
        
        Asset asset = new Asset();
        asset.setCardMoney(100);
        asset.setBankId(1);
        asset.setUserId(1);
        AssetDao assetDao = new AssetDaoImpl();
        System.out.println(assetDao.updateAsser(asset));
    }
    @Test
    public void testAddAsset2() {
        
        Asset asset = new Asset();
        asset.setCardMoney(100);
        asset.setBankId(1);
        asset.setUserId(1);
        AssetDao assetDao = new AssetDaoImpl();
        System.out.println(assetDao.reduceAsset(asset));
    }
}
