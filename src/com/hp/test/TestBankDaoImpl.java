package com.hp.test;

import java.util.List;

import org.junit.Test;

import com.hp.dao.BankDao;
import com.hp.dao.impl.BankDaoImpl;
import com.hp.po.Bank;

public class TestBankDaoImpl {
    
    @Test
    public void testAdd() {
        
        Bank bank = new Bank();
        bank.setBankName("工商银行");
        bank.setBankTel("1234567");
        BankDao bankDao = new BankDaoImpl();
        bankDao.addBank(bank);
    }

    @Test
    public void testUpdate() {
        
        BankDao bankDao = new BankDaoImpl();
      // bankDao.updateBank("农业银行", "建设银行");
    }
    @Test
    public void testDelete() {
        
        BankDao bankDao = new BankDaoImpl();
        bankDao.deleteBank(1);
    }
    
    @Test
    public void testFindAll() {
        BankDao bankDao = new BankDaoImpl();
        List<Bank> list = bankDao.findAllBank();
        for (Bank bank : list) {
            System.out.println(bank);
        }
    }
    @Test
    public void testFindById() {
        
        BankDao bankDao = new BankDaoImpl();
        Bank bank = bankDao.findById(3);
        System.out.println(bank);
    }
}
