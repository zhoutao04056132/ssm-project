package com.zhou.dao;

import com.github.pagehelper.Page;
import com.zhou.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IUserDao {
    User selectUserById(Long id) throws DataAccessException;
    User selectUserByName(@Param("name") String name, @Param("realName") String realName) throws DataAccessException;
    Page<User> selectUsersByNameByPage(String name) throws DataAccessException;
    int insertUser(User user) throws DataAccessException;
    int insertUser1(User user) throws DataAccessException;
    int insertUserBatch(List<User> userList) throws DataAccessException;
    int insertUserBatch1(List<User> userList) throws DataAccessException;
    int updateUserName(String name) throws DataAccessException;
}
