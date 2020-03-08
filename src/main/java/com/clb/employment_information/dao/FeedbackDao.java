package com.clb.employment_information.dao;


import com.clb.employment_information.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedbackDao {
    void insertFeedback(Feedback feedback);

    List<Feedback> getAllFeedback();
}
