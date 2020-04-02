package com.zhou.service;

import com.zhou.model.User1;
import org.springframework.dao.DataAccessException;

public interface IUser1Service {
    User1 selectUser1ById(Integer id) throws DataAccessException;
    int selectUser1Count() throws DataAccessException;
}
