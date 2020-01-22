package com.zhou.service;

import com.zhou.model.User;

import java.util.List;

public interface IUserService {
    User selectUserById(Long id);
    User selectUserByName(String name, String realName);
    int insertUser(User user);

    User insertUserAndReturnUser(User user);
    int insertUserBatch(List<User> userList);

    List<User> insertUserBatchAndReturnUserList(List<User> userList);
    int updateUserName(String name);
}
