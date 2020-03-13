package com.zhou.service;

import com.github.pagehelper.Page;
import com.zhou.model.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IUserService {
    User selectUserById(Long id) throws DataAccessException;
    User selectUserByName(String name, String realName) throws DataAccessException;
    Page<User> selectUsersByPage(Integer page, Integer size, String name) throws DataAccessException;

    int insertUser(User user) throws DataAccessException;

    User insertUserAndReturnUser(User user) throws DataAccessException;
    int insertUserBatch(List<User> userList) throws DataAccessException;

    List<User> insertUserBatchAndReturnUserList(List<User> userList) throws DataAccessException;
    int updateUserName(String name) throws DataAccessException;
}
