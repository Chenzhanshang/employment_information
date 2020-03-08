package com.clb.employment_information.service.impl;

import com.clb.employment_information.dao.FeedbackDao;
import com.clb.employment_information.entity.Feedback;
import com.clb.employment_information.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;
    @Override
    public void insertFeedback(Feedback feedback) {
        feedbackDao.insertFeedback(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackDao.getAllFeedback();
    }
}
