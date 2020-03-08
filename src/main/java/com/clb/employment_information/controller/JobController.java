package com.clb.employment_information.controller;


import com.clb.employment_information.entity.Chair;
import com.clb.employment_information.entity.Job;
import com.clb.employment_information.service.JobService;
import com.clb.employment_information.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    //发布招聘会
    @RequestMapping(value = "/issueJob",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage issueJob(@RequestBody Job job){
        job.setJobId(UUID.randomUUID().toString());
        job.setNowSum(0);
        System.out.println(job);
        try {
            jobService.insertJob(job);
            return new ResponseMessage("1","发布成功");

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","发布失败");
        }
    }

    //获取所有招聘会
    @RequestMapping(value = "/getAllJob",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getAllJob(){
        try {
            List<Job> jobList =  jobService.getAllJob();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("jobList",jobList);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }

    //报名参加招聘会
    @RequestMapping(value = "/apply",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage apply(String jobId, String userId){
        try {
            if(jobService.selectJobUser(jobId,userId) != null){
                return new ResponseMessage("0","报名失败，你已报名该招聘会");
            }
            jobService.apply(jobId,userId);
            ResponseMessage responseMessage = new ResponseMessage("1","报名成功");
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","报名失败");
        }
    }

    //修改招聘会
    @RequestMapping(value = "/updateJob",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage updateJob(@RequestBody Job job){
        System.out.println(job);
        try {
            jobService.updateJob(job);
            return new ResponseMessage("1","修改成功");

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","修改失败");
        }
    }

    //删除招聘会
    @RequestMapping(value = "/deleteJob",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage deleteJob(String jobId){
        try {
            jobService.deleteJob(jobId);
            ResponseMessage responseMessage = new ResponseMessage("1","删除成功");
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","删除失败");
        }
    }

}
