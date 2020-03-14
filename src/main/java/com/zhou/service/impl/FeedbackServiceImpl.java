package com.zhou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhou.dao.IFeedbackDao;
import com.zhou.model.Feedback;
import com.zhou.service.IFeedbackService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("feedbackService")
public class FeedbackServiceImpl implements IFeedbackService {
    @Resource
    private IFeedbackDao feedbackDao;

    @Override
    public Feedback selectFeedbackById(Integer id) throws DataAccessException {
        return feedbackDao.selectFeedbackById(id);
    }

    @Override
    public Page<Feedback> selectFeedbackByUserIdByPage(Integer userId, Integer page, Integer size) throws DataAccessException {
        PageHelper.startPage(page, size);
        Page<Feedback> feedbackPage = feedbackDao.selectFeedbackByUserIdByPage(userId);

        return feedbackPage;
    }

    @Override
    public Feedback insertFeedback(Feedback feedback) throws DataAccessException {
        int result = feedbackDao.insertFeedback(feedback);
        if (result != 1) {
            return null;
        }

        return feedback;
    }

    @Override
    public int updateFeedback(Feedback feedback) throws DataAccessException {
        return feedbackDao.updateFeedback(feedback);
    }

    @Override
    public int deleteFeedbackById(Integer id) throws DataAccessException {
        return feedbackDao.deleteFeedbackById(id);
    }
}
