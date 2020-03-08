package com.clb.employment_information.service;


import com.clb.employment_information.entity.Job;
import com.clb.employment_information.entity.JobUser;

import java.util.List;

public interface JobService {
    void insertJob(Job job);

    List<Job> getAllJob();

    JobUser selectJobUser(String jobId, String userId);

    void apply(String jobId, String userId);

    void updateJob(Job job);

    void deleteJob(String jobId);
}
