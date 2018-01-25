package com.hp.service.imlp;

import java.util.List;
import java.util.Scanner;

import com.hp.dao.AssetDao;
import com.hp.dao.BankDao;
import com.hp.dao.UserDao;
import com.hp.dao.impl.AssetDaoImpl;
import com.hp.dao.impl.BankDaoImpl;
import com.hp.dao.impl.UserDaoImpl;
import com.hp.po.Asset;
import com.hp.po.Asset1;
import com.hp.service.AdminService;
import com.hp.service.UserService;
import com.hp.view.UserUI;

public class UserServiceImpl implements UserService {

    private UserUI userUI = null;
    private Scanner scanner = null;
    private UserService userService = null;
    private UserDao userDao = null;
    private AssetDao assetDao = null;
    private List<Asset1> assets = null;
    private BankDao bankDao = null;
    private AdminService ad = null;

    @Override
    public void main() {
        scanner = new Scanner(System.in);
        userUI = new UserUI();
        userUI.firt();
        userDao = new UserDaoImpl();
        switch (scanner.nextInt()) {
        case 1:

            login();
            main();
            break;

        case 2:        
            if (userDao.registerUser(userUI.register())) {
                System.out.println("注册成功，返回登录");
            }else {
                System.out.println("注册失败");
            }
            login();
            break;
        default:
            System.out.println("输入错误，请重新输入");
            main();
            break;
        }
    }

    @Override
    public void login() {

        userUI = new UserUI();
        userDao = new UserDaoImpl();
        if (userDao.loginIn(userUI.userLogin())) {
            loginSuccess();
        } else {
            System.out.println("账户或密码错误");
            login();
        }

    }

    @Override
    public void loginSuccess() {

        scanner = new Scanner(System.in);
        userUI = new UserUI();
        ad = new AdminServiceImpl();
        userUI.main();
        int k = 0;
        k = scanner.nextInt();
        switch (k) {
        case 1:

            findAsset();
            loginSuccess();
            break;
        case 2:
            addAsset();
            loginSuccess();
            break;
        case 3:
            get();
            loginSuccess();
            break;
        case 4:
            getAll();
            loginSuccess();
            break;
        case 5:
            updatePassword();
            loginSuccess();
            break;
        case 6:
            ad.main();
            break;
        default:
            System.out.println("输入错误，请重新输入");
            loginSuccess();
            break;
        }
    }

    @Override
    public void findAsset() {

        assetDao = new AssetDaoImpl();
        userUI = new UserUI();
        userUI.findAsset();
        assets = assetDao.findAsset(UserDaoImpl.userId);
        for (Asset1 asset : assets) {
            System.out.println(asset);
        }
    }

    @Override
    public void addAsset() {

        assetDao = new AssetDaoImpl();
        userUI = new UserUI();
        bankDao = new BankDaoImpl();

        if (assetDao.addAsset(userUI.addAsset(bankDao.findAllBank()))) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }

    public void get() {
        int k = 0;
        userUI = new UserUI();
        scanner = new Scanner(System.in);
        assetDao = new AssetDaoImpl();
        userUI.saveOr();
        k = scanner.nextInt();
        Asset a = null;

        switch (k) {
        case 1:

            if (assetDao.updateAsser(userUI.saveAsset(assetDao.findAsset(UserDaoImpl.userId)))) {
                System.out.println("存入成功");
            } else {
                System.out.println("存入失败");
                System.out.println("您无此账户");
            }

            break;

        case 2:
            a = userUI.deleteAsset(assetDao.findAsset(UserDaoImpl.userId));
            if ((assetDao.chakan(a) - a.getCardMoney()) > 0) {
                if (assetDao.reduceAsset(a)) {
                    System.out.println("提取成功");
                } else {
                    System.out.println("提取失败");
                }
            } else {
                System.out.println("余额不够");
            }

            break;
        default:
            System.out.println("输入错误");
            break;
        }

    }

    public void getAll() {
        userUI = new UserUI();
        assetDao = new AssetDaoImpl();
        userUI.findAll(assetDao.findAll(UserDaoImpl.userId));
    }

    public void updatePassword() {
        
        String oldPassword;
        String newPassword;
        scanner = new Scanner(System.in);
        userDao = new UserDaoImpl();
        System.out.println("-------修改密码-------");
        System.out.println("原密码为：");
        oldPassword = scanner.next();
        System.out.println("新密码为：");
        newPassword = scanner.next();
        if ( userDao.updatePassword(oldPassword, newPassword, UserDaoImpl.userId)) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
            System.out.println("原始密码输入错误");
        }
    }

}
