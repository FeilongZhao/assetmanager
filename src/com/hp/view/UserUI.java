package com.hp.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hp.dao.UserDao;
import com.hp.dao.impl.UserDaoImpl;
import com.hp.po.Asset;
import com.hp.po.Asset1;
import com.hp.po.Bank;
import com.hp.po.User;

public class UserUI {

    private User user = null;
    private Scanner scanner = null;
    private Asset asset = null;

    public void firt() {

        System.out.println("-------个人资产管理系统-------");
        System.out.println("********用户界面********");
        System.out.println("*********1.登录*********");
        System.out.println("*********2.注册*********");
    }

    public User register() {

        user = new User();
        scanner = new Scanner(System.in);
        System.out.println("-------个人资产管理系统-------");
        System.out.println("***********用户注册***********");
        System.out.println("请输入用户名：");
        user.setUserName(scanner.nextLine());
        System.out.println("请输入密码：");
        user.setPassword(scanner.nextLine());
        System.out.println("请输入真实姓名：");
        user.setRealName(scanner.nextLine());
        System.out.println("请输入性别：");
        user.setSex(scanner.nextLine());
        System.out.println("请输入电话号码：");
        user.setTel(scanner.nextLine());
        System.out.println("请输入身份证号：");
        user.setIdCard(scanner.nextLine());
        System.out.println("请输入联系地址：");
        user.setAddress(scanner.nextLine());

        return user;
    }

    public User userLogin() {

        user = new User();
        scanner = new Scanner(System.in);
        System.out.println("-------个人资产管理系统-------");
        System.out.println("***********用户登录***********");
        System.out.println("请输入用户名：");
        user.setUserName(scanner.nextLine());
        System.out.println("请输入密码：");
        user.setPassword(scanner.nextLine());
        return user;
    }

    public void findAsset() {

        System.out.println("-------查看所以资产-------");
    }

    public Asset addAsset(List<Bank> list) {

        asset = new Asset();
        scanner = new Scanner(System.in);
        System.out.println("-------目前存在的银行信息-------");
        System.out.println("目前存在的银行信息：");
        for (Bank bank : list) {
            System.out.println(bank);
        }
        System.out.println("请输入银行id：");
        asset.setBankId(scanner.nextInt());
        System.out.println("请输入卡号：");
        asset.setCardNum(scanner.next());
        System.out.println("请输入金额：");
        asset.setCardMoney(scanner.nextDouble());
        asset.setCardDate(new Date());
        asset.setUserId(UserDaoImpl.userId);
        return asset;
    }

    public void main() {

        
        System.out.println("-------个人资产管理系统-------");
        System.out.println("********【欢迎您：用户" + "" + "】********");
        System.out.println("1.查看资产    2.添加新资产    3.存取资产    4.查看总资产    5.修改密码    6.返回登录主菜单");
        System.out.println("-------个人资产管理系统-------");
        System.out.println("请选择业务：");
        
    }

    public void saveOr() {

        scanner = new Scanner(System.in);
        System.out.println("-------存取资产-------");
        System.out.println("请选择存入或者提取资产：1.存入    2.提取");
   
    }

    public Asset deleteAsset(List<Asset1> list) {

        asset = new Asset();
        scanner = new Scanner(System.in);
        System.out.println("-------提取-------");
        System.out.println("您目前的资产如下：");
        for (Asset1 asset1 : list) {
            System.out.println(asset1);
        }
        System.out.println("请输入银行id：");
        asset.setBankId(scanner.nextInt());
        System.out.println("请输入银行卡号：");
        asset.setCardNum(scanner.next());
        System.out.println("请输入提取金额：");
        asset.setCardMoney(scanner.nextDouble());
        asset.setUserId(UserDaoImpl.userId);
        return asset;
    }
    
    public Asset saveAsset(List<Asset1> list) {
        asset = new Asset();
        scanner = new Scanner(System.in);
        System.out.println("-------存入-------");
        System.out.println("您目前拥有的资产如下：");
        for (Asset1 asset1 : list) {
            System.out.println(asset1);
        }
        System.out.println("请输入银行id：");
        asset.setBankId(scanner.nextInt());
        System.out.println("请输入银行卡号：");
        asset.setCardNum(scanner.next());
        System.out.println("请输入存入金额：");
        asset.setCardMoney(scanner.nextDouble());
        asset.setUserId(UserDaoImpl.userId);
        return asset;
    }
    
    public void findAll(double money) {
        
        System.out.println("-------查看总资产-------");
        System.out.println("您当前的总资产为：" + money);
    }

}
