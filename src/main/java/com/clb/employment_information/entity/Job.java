package com.clb.employment_information.entity;

public class Job {
    private String jobId;

    private String jobTime;

    private String jobSite;

    private Integer jobSum;

    private Integer nowSum;

    private String jobName;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime == null ? null : jobTime.trim();
    }

    public String getJobSite() {
        return jobSite;
    }

    public void setJobSite(String jobSite) {
        this.jobSite = jobSite == null ? null : jobSite.trim();
    }

    public Integer getJobSum() {
        return jobSum;
    }

    public void setJobSum(Integer jobSum) {
        this.jobSum = jobSum;
    }

    public Integer getNowSum() {
        return nowSum;
    }

    public void setNowSum(Integer nowSum) {
        this.nowSum = nowSum;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }
}