package com.clb.employment_information.service.impl;

import com.clb.employment_information.dao.JobDao;
import com.clb.employment_information.entity.Job;
import com.clb.employment_information.entity.JobUser;
import com.clb.employment_information.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;
    @Override
    public void insertJob(Job job) {
        jobDao.insertJob(job);
    }

    @Override
    public List<Job> getAllJob() {
        return jobDao.getAllJob();
    }

    @Override
    public JobUser selectJobUser(String jobId, String userId) {
        return jobDao.selectJobUser(jobId,userId);
    }

    @Override
    public void apply(String jobId, String userId) {
        jobDao.insertJobUser( jobId,  userId);
        jobDao.updateJobNowSum(jobId);
    }

    @Override
    public void updateJob(Job job) {
        jobDao.updateJob(job);
    }

    @Override
    public void deleteJob(String jobId) {
        jobDao.deleteJobUser(jobId);
        jobDao.deleteJob(jobId);
    }
}
