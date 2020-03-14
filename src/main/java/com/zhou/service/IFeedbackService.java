package com.zhou.service;

import com.github.pagehelper.Page;
import com.zhou.model.Feedback;
import org.springframework.dao.DataAccessException;

public interface IFeedbackService {
    Feedback selectFeedbackById(Integer id) throws DataAccessException;
    Page<Feedback> selectFeedbackByUserIdByPage(Integer userId, Integer page, Integer size) throws DataAccessException;
    Feedback insertFeedback(Feedback feedback) throws DataAccessException;
    int updateFeedback(Feedback feedback) throws DataAccessException;
    int deleteFeedbackById(Integer id) throws DataAccessException;
}
