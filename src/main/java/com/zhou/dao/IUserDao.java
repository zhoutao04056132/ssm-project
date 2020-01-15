package com.zhou.dao;

import com.zhou.model.User;

public interface IUserDao {
    User selectUserById(long id);
    User selectUserByName(String name, String realName);
}
