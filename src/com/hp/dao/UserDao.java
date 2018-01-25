package com.hp.dao;

import java.util.List;

import com.hp.po.Asset;
import com.hp.po.User;

public interface UserDao {

    Boolean loginIn(User user);

    Boolean registerUser(User user);

    Boolean updatePassword(String oldPassword, String newPassword, int userId);

    Boolean findUserByName(String userName);

}
