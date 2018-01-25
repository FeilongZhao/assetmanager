package com.hp.service;

import com.hp.po.Bank;

public interface AdminService {

    void main();
    void login();
    void select();
    void findAllUser();
    void addBank(Bank bank);
    void updateBank();
    void deleteBank();
    void findAllBank();
}
