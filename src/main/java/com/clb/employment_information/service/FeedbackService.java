package com.clb.employment_information.service;

import com.clb.employment_information.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    void insertFeedback(Feedback feedback);

    List<Feedback> getAllFeedback();
}
