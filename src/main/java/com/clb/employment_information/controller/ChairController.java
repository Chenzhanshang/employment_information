package com.clb.employment_information.controller;

import com.clb.employment_information.entity.Chair;
import com.clb.employment_information.service.ChairService;
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
@RequestMapping("/chair")
public class ChairController {
    @Autowired
    private ChairService chairService;

    //发布讲座
    @RequestMapping(value = "issueChair",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage issueChair(@RequestBody Chair chair){
        chair.setChairId(UUID.randomUUID().toString());
        chair.setNowSum(0);
        System.out.println(chair);
        try {
            chairService.insertChair(chair);
            return new ResponseMessage("1","发布成功");

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","发布失败");
        }
    }
    //修改讲座
    @RequestMapping(value = "updateChair",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage updateChair(@RequestBody Chair chair){
        System.out.println(chair);
        try {
            chairService.updateChair(chair);
            return new ResponseMessage("1","修改成功");

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","修改失败");
        }
    }

    //获取所有讲座
    @RequestMapping(value = "getAllChair",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getAllChair(){
        try {
            List<Chair> chairList =  chairService.getAllChair();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("chairList",chairList);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }

    //报名参加讲座
    @RequestMapping(value = "/apply",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage apply(String chairId, String userId){
        try {
            if(chairService.selectChairUser(chairId,userId) != null){
                return new ResponseMessage("0","报名失败，你已报名该讲座");
            }
            chairService.apply(chairId,userId);
            ResponseMessage responseMessage = new ResponseMessage("1","报名成功");
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","报名失败");
        }
    }
    //删除讲座
    @RequestMapping(value = "/deleteChair",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage deleteChair(String chairId){
        try {
            chairService.deleteChair(chairId);
            ResponseMessage responseMessage = new ResponseMessage("1","删除成功");
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","删除失败");
        }
    }
}
