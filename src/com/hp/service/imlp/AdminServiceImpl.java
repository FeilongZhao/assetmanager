package com.hp.service.imlp;

import java.util.List;
import java.util.Scanner;

import com.hp.dao.AdminDao;
import com.hp.dao.BankDao;
import com.hp.dao.impl.AdminDaoImpl;
import com.hp.dao.impl.BankDaoImpl;
import com.hp.po.Bank;
import com.hp.po.User;
import com.hp.service.AdminService;
import com.hp.service.UserService;
import com.hp.view.AdminUI;
import com.hp.view.MainUI;

public class AdminServiceImpl implements AdminService {

    private MainUI mainUI = null;
    private Scanner scanner = null;
    private UserService userService = null;
    private AdminUI adminUI = null;
    private AdminDao adminDao = null;
    private List<User> list = null;
    private BankDao bankDao = null;

    @Override
    public void main() {

        mainUI = new MainUI();
        scanner = new Scanner(System.in);
        mainUI.main();

        switch (scanner.nextInt()) {
        case 1:

            login();
            break;

        case 2:
            userService = new UserServiceImpl();
            userService.main();
            break;
        case 0:
            System.exit(0);
            break;
        default:
            System.out.println("输入错误");
            main();
            break;
        }

    }

    @Override
    public void login() {

        adminUI = new AdminUI();
        adminDao = new AdminDaoImpl();
        if (adminDao.loginIn(adminUI.adminLogin())) {
            select();
        }else {
            System.out.println("用户名或密码错误，请重新输入");
            login();
        }

    }

    @Override
    public void select() {

        scanner = new Scanner(System.in);
        adminUI = new AdminUI();
        adminUI.main();
        switch (scanner.nextInt()) {
        case 1:

            adminUI.findAllUser();
            findAllUser();
            select();
            break;

        case 2:
            addBank(adminUI.addBank());
            select();
            break;
        case 3:
            updateBank();
            select();
            break;
        case 4:
            deleteBank();
            select();
            break;
        case 5:
            adminUI.findAllBank();
            findAllBank();
            select();
            break;
        case 6:
            main();
            break;
        default:
            System.out.println("输入错误，请重新输入");
            select();
            break;
        }

    }

    @Override
    public void findAllUser() {
        adminDao = new AdminDaoImpl();
        list = adminDao.findAllUser();
        for (User user : list) {
            System.out.println(user);
        }

    }

    @Override
    public void addBank(Bank bank) {

        bankDao = new BankDaoImpl();
        if (bankDao.findByName(bank.getBankName()) == null) {
            if (bankDao.addBank(bank)) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } else {
            System.out.println("银行存在");

        }
    }

    @Override
    public void updateBank() {
        int num = 0;
        scanner = new Scanner(System.in);
        
        System.out.println("请输入要修改的银行编号：");
        bankDao = new BankDaoImpl();
        num = scanner.nextInt();

        if (bankDao.findById(num) != null) {

            Bank bank = adminUI.updateBank();
            if (bankDao.updateBank(bank.getBankName(), num, bank.getBankTel())) {

                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        }else {
            System.out.println("银行不存在");
        }
        

    }

    @Override
    public void deleteBank() {
      
        int num = 0;
        Bank bank = null;
        String flag = null;
        scanner = new Scanner(System.in);
        bankDao = new BankDaoImpl();
        System.out.println("------删除银行------");
        System.out.println("请输入您要删除银行的编号：");
        num = scanner.nextInt();
        bank = bankDao.findById(num);
        if (bank != null) {
            System.out.println(bank);
            adminUI.deleteBank();
            
            flag = scanner.next();
            
            if ("y".equals(flag) || "y" == flag) {
                bankDao.deleteBank(num);
                System.out.println("删除成功");
            }else {
                System.out.println("取消");
            }
        }else {
            System.out.println("银行不存在");
        }               
    }

    @Override
    public void findAllBank() {
       
        List<Bank> listBank = null;
        bankDao = new BankDaoImpl();
        listBank = bankDao.findAllBank();
        for (Bank bank : listBank) {
            System.out.println(bank);
        }
        
        
    }

}
