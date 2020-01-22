package com.zhou.dao;

import com.zhou.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IUserDao {
    User selectUserById(Long id);
    User selectUserByName(@Param("name") String name, @Param("realName") String realName) throws DataAccessException;
    int insertUser(User user);
    int insertUser1(User user);
    int insertUserBatch(List<User> userList) throws DataAccessException;
    int insertUserBatch1(List<User> userList) throws DataAccessException;
    int updateUserName(String name) throws DataAccessException;
}
