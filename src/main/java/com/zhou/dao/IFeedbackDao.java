package com.zhou.dao;

import com.github.pagehelper.Page;
import com.zhou.model.Feedback;
import org.springframework.dao.DataAccessException;

public interface IFeedbackDao {
    Feedback selectFeedbackById(Integer id) throws DataAccessException;
    Page<Feedback> selectFeedbackByUserIdByPage(Integer userId) throws DataAccessException;
    int insertFeedback(Feedback feedback) throws DataAccessException;
    int updateFeedback(Feedback feedback) throws DataAccessException;
    int deleteFeedbackById(Integer id) throws DataAccessException;
}
