package com.zhou.service.impl;

import com.zhou.dao.IUserDao;
import com.zhou.model.User;
import com.zhou.service.IUserService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public User selectUserById(Long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public User selectUserByName(String name, String realName) {
        User user = null;
        try {
            user = userDao.selectUserByName(name, realName);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    /**
     * 返回成功插入后的对象，失败则返回的对象为null
     */
    public User insertUserAndReturnUser(User user) {
        int result = userDao.insertUser1(user);
        if (result != 1) {
            return null;
        }
        return user;
    }

    @Override
    public int insertUserBatch(List<User> userList) {
        System.out.println("service-----------userList:" + userList.toString());
        int result = 0;
        try {
            result = userDao.insertUserBatch(userList);
        } catch (DataAccessException e) {
            result = -1;
        }

        return result;
    }

    @Override
    /**
     * 返回成功插入的对象列表，db层批量插入是在一个事务，即整体插入成功或失败
     */
    public List<User> insertUserBatchAndReturnUserList(List<User> userList) {
        System.out.println("service-----------userList:" + userList.toString());
        int result = 0;
        try {
            result = userDao.insertUserBatch1(userList);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

        if (result == userList.size()) {
            return userList;
        }
        return null;
    }

    @Override
    public int updateUserName(String name) {
        int result = 0;
        try {
            result = userDao.updateUserName(name);
        } catch (DataAccessException e) {
            result = -1;
        }

        return  result;
    }
}
