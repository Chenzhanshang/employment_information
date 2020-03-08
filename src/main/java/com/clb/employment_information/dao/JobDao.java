package com.clb.employment_information.dao;

import com.clb.employment_information.entity.Job;
import com.clb.employment_information.entity.JobUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobDao {
    void insertJob(Job job);

    List<Job> getAllJob();

    JobUser selectJobUser(String jobId, String userId);

    void insertJobUser(String jobId, String userId);

    void updateJobNowSum(String jobId);

    void updateJob(Job job);

    void deleteJob(String jobId);

    void deleteJobUser(String jobId);

    void deleteJobUserByUserId(String userId);
}
