package com.zhou.service.impl;

import com.zhou.dao.IUserDao;
import com.zhou.model.User;
import com.zhou.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public User selectUserById(long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public User selectUserByName(String name, String realName) {
        return userDao.selectUserByName(name, realName);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
