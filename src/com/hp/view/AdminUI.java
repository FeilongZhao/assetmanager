package com.hp.view;

import java.util.Scanner;

import com.hp.po.Admin;
import com.hp.po.Bank;

public class AdminUI {

    private Scanner scanner = null;
    private Admin admin = null;
    private Bank bank = null;
 

    public Admin adminLogin() {
        admin = new Admin();
        scanner = new Scanner(System.in);
        System.out.println("-------个人资产管理系统-------");
        System.out.println("********管理员登录********");
        System.out.println("用户名：");
        admin.setAdminName(scanner.nextLine());
        System.out.println("密码：");
        admin.setAdminPassword(scanner.nextLine());
        return admin;
    }

    public void main() {

        System.out.println("********欢迎您，管理员：" + " " + "********");
        System.out.println("1.查看所有用户      2.添加银行      3.修改银行      4.删除银行      5.查看所有银行      6.返回登录主菜单");
        System.out.println("------个人资产管理系统------");
        System.out.println("请选择业务：");
    }

    public void findAllUser() {

        System.out.println("-------查看所有用户-------");

    }

    public Bank addBank() {

        bank = new Bank();
        scanner = new Scanner(System.in);
        System.out.println("-------添加银行-------");
        System.out.println("请输入银行名：");
        bank.setBankName(scanner.nextLine());
        System.out.println("请输入银行电话：");
        bank.setBankTel(scanner.nextLine());
        return bank;
    }

    public Bank updateBank() {

        bank = new Bank();
        scanner = new Scanner(System.in);
        System.out.println("请输入新的银行名：");
        bank.setBankName(scanner.nextLine());
        System.out.println("请输入新的银行电话：");
        bank.setBankTel(scanner.nextLine());
        return bank;
    }

    public void deleteBank() {

        System.out.println("确定要删除吗？y/n");

    }

    public void findAllBank() {

        System.out.println("-------查看所有银行-------");
    }
}
