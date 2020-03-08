package com.clb.employment_information.entity;


public class JobUser {
    private String jobId;

    private String userId;

    public String getJobId() {
        return jobId;
    }

    @Override
    public String toString() {
        return "JobUser{" +
                "jobId='" + jobId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
