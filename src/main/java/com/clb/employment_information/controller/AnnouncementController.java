package com.clb.employment_information.controller;

import com.clb.employment_information.entity.Announcement;
import com.clb.employment_information.service.AnnouncementService;
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
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    //发布公告
    @RequestMapping(value = "/issueAnnouncement", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage issueAnnouncement(@RequestBody Announcement announcement){
        announcement.setAnnouncementId(UUID.randomUUID().toString());
        System.out.println(announcement);
        try {
            announcementService.insertAnnouncement(announcement);
            return new ResponseMessage("1","发布成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","发布失败");
        }


    }

    //修改公告
    @RequestMapping(value = "/updateAnnouncement", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage updateAnnouncement(@RequestBody Announcement announcement){
        System.out.println(announcement);
        try {
            announcementService.updateAnnouncement(announcement);
            return new ResponseMessage("1","修改成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","修改失败");
        }


    }

    //删除公告
    @RequestMapping("/deleteAnnouncement")
    public @ResponseBody
    ResponseMessage deleteAnnouncement(String announcementId){
        System.out.println(announcementId);
        try {
            announcementService.deleteAnnouncement(announcementId);
            return new ResponseMessage("1","删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","删除失败");
        }


    }
    //获取全部公告
    @RequestMapping(value = "/getAllAnnouncement", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getAllAnnouncement(){
        try {
            List<Announcement> announcementList = announcementService.getAllAnnouncement();
            ResponseMessage responseMessage =  new ResponseMessage("1","获取成功");
            responseMessage.getData().put("announcementList",announcementList);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }

    }
}
