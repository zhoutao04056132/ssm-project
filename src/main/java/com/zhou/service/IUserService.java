package com.zhou.service;

import com.zhou.model.User;

public interface IUserService {
    User selectUserById(long id);
    User selectUserByName(String name, String realName);
}
