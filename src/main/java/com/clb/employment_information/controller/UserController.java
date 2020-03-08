package com.clb.employment_information.controller;

import com.clb.employment_information.entity.User;
import com.clb.employment_information.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage register(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        //角色0为普通用户,1为管理员
        user.setRole(0);
        System.out.println(user);
        try{
            User user1 = userService.getUserByUserName(user.getUserName());
            if(user1 != null){
                return new ResponseMessage("-1","注册失败，用户名已存在");
            }
            userService.insertUser(user);
            return new ResponseMessage("1","注册成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","注册失败");
        }

    }

    //修改用户信息
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage update(@RequestBody User user){
        try{
            userService.update(user);
            return new ResponseMessage("1","修改成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","修改失败");
        }

    }

    //修改用户密码
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage updatePassword(@RequestBody User user){
        try{
            userService.updatePassword(user);
            return new ResponseMessage("1","修改成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","修改失败");
        }

    }



    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage login(@RequestBody User user){

        try{
            User user1 = userService.getUserByUserNameAndPassword(user);
            if(user1 != null){
                if(user1.getRole() == 0){
                    ResponseMessage responseMessage = new ResponseMessage("1","普通用户登录成功");
                    responseMessage.getData().put("user",user1);
                    return responseMessage;
                }
                else if(user1.getRole() == 1){
                    ResponseMessage responseMessage = new ResponseMessage("1","管理员登录成功");
                    responseMessage.getData().put("user",user1);
                    return responseMessage;
                }
                else{
                    return new ResponseMessage("0","登录失败");
                }
            }
            else{
                return new ResponseMessage("-1","用户名或密码错误");
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","登录失败");
        }

    }

    //找回账号
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage find(@RequestBody User user){
        System.out.println(user);
        try{
            User user1 = userService.getUserByUserMsg(user);
            if(user1 != null){
                ResponseMessage responseMessage = new ResponseMessage("1","找回成功");
                responseMessage.getData().put("user",user1);
                return responseMessage;
            }
            else{
                return new ResponseMessage("-1","找回失败，请检出输入信息是否有误");
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","服务器出错了");
        }

    }

    //获得所有用户
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getAllUser(){
        try{
            List<User> userList = userService.getAllUser();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("userList",userList);
            return responseMessage;

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }

    }
    //删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage deleteUser(String userId){
        try{
            userService.deleteUser(userId);
            ResponseMessage responseMessage = new ResponseMessage("1","删除成功");
            return responseMessage;

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","删除失败");
        }

    }

}
