package com.zhou.service.impl;

import com.zhou.dao.IUser1Dao;
import com.zhou.model.User1;
import com.zhou.service.IUser1Service;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("user1Service")
public class User1ServiceImpl implements IUser1Service {
    @Resource
    private IUser1Dao user1Dao;

    @Override
    public User1 selectUser1ById(Integer id) throws DataAccessException {
        return user1Dao.selectUser1ById(id);
    }

    @Override
    public int selectUser1Count() throws DataAccessException {
        return user1Dao.selectUser1Count();
    }
}
