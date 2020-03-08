package com.clb.employment_information.controller;

import com.clb.employment_information.service.FileService;
import com.clb.employment_information.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    /**
     * 校验上传的文件，进行保存
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage uploadFile(@RequestParam("multipartFile") MultipartFile multipartFile ,@RequestParam("fileDescribe") String fileDescribe) throws IOException {
        System.out.println(fileDescribe);
        //设置文件保存路径
        final String path = "D:\\file\\";
        String fileName = multipartFile.getOriginalFilename();
        //封装文件对象
        File file = new File(path, fileName);

        //判断文件夹是否存在，如果不存在则创建
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        try {
            // 文件写入
            multipartFile.transferTo(file);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "操作失败");
        }
        ResponseMessage responseMessage = new ResponseMessage("1", "操作成功");
        if(fileName != null && !"".equals(fileName) ){
            //写入数据库
            com.clb.employment_information.entity.File file1 = new com.clb.employment_information.entity.File();
            file1.setFileId(UUID.randomUUID().toString());
            file1.setFileName(fileName);
            file1.setFilePath(path + fileName);
            file1.setFileDescribe(fileDescribe);
            fileService.insertFile(file1);
        }
        return responseMessage;
    }

    @RequestMapping("/getAllFile")
    public @ResponseBody ResponseMessage getAllFile(){
        try {
            List<com.clb.employment_information.entity.File> fileList = fileService.getAllFile();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("fileList",fileList);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }

    /**
     * 文件下载
     * @param file
     * @param response
     * @return
     */
    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage downloadFile(@RequestBody com.clb.employment_information.entity.File file, HttpServletResponse response) {
        //获取文件的信息
        try {
            //拿到文件路径
            String filePath = file.getFilePath();
            java.io.File f = new java.io.File(filePath);
            if (f.exists()) {
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(f);
                    bis = new BufferedInputStream(fis);
                    //从响应中拿到输出流对象
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return new ResponseMessage("1", "下载文件成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    return new ResponseMessage("-1", "下载文件失败");
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return new ResponseMessage("-1", "下载文件不存在");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("-1", "下载文件失败");
        }
    }

    @RequestMapping(value = "/updateFile", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage updateFile(@RequestBody com.clb.employment_information.entity.File file){
        System.out.println(file);
        try {
            fileService.updateFile(file);
            return new ResponseMessage("1","修改成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","修改失败");
        }

    }

    @RequestMapping("/deleteFile")
    public @ResponseBody
    ResponseMessage deleteFile(String fileId){
        try {
            fileService.deleteFile(fileId);
            return new ResponseMessage("1","删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","删除失败");
        }

    }
}
