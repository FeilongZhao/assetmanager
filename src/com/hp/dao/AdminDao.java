package com.hp.dao;

import java.util.List;

import com.hp.po.Admin;
import com.hp.po.Bank;
import com.hp.po.User;

public interface AdminDao {

    Boolean loginIn(Admin admin);

    List<User> findAllUser();

}
