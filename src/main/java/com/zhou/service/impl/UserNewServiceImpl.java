package com.zhou.service.impl;

import com.zhou.dao.IUserNewDao;
import com.zhou.model.UserNew;
import com.zhou.service.IUserNewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userNewService")
public class UserNewServiceImpl implements IUserNewService {
    @Resource
    private IUserNewDao userNewDao;

    @Override
    public UserNew selectUserNewById(long id) {
        return userNewDao.selectUserNewById(id);
    }

}
