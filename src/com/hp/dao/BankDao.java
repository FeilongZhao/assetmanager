package com.hp.dao;

import java.util.List;
import com.hp.po.Bank;

public interface BankDao {
    Boolean addBank(Bank bank);

    Boolean updateBank(String newBankName,int bankId,String bankTel);

    Boolean deleteBank(int bankId);

    List<Bank> findAllBank();
    
    Bank findByName(String bankName);

    Bank findById(int bankId);
}
