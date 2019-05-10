package com.xiao.controller;


import com.jcraft.jsch.SftpException;
import com.xiao.Utils.SFTPUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/**
 * @Description 富文本编辑器图片上传
 * @Auther: 笑笑
 * @Date: 21:04 2018/9/25
 */
@Controller
public class FileUploadController {


    @Value("${upload.path}")
    private String uploadPath;  //读取配置文件中上传图片路径

    @Value("${upload.host}")
    private String host;        //sftp主机ip

    @Value("${upload.username}")
    private String username;    //用户名

    @Value("${upload.password}")
    private String password;    //密码

    @Value("${upload.port}")
    private int  port;          //sftp上传端口

    @Value("${upload.url}")
    private String serverUtl;

    @RequestMapping(value = "/upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile imgFile){
        Map<String,Object> map = new HashMap<>();
        String ext = FilenameUtils.getExtension(imgFile.getOriginalFilename());
        String newName = System.currentTimeMillis()+"."+ext;

        //获取文件输入流
        InputStream in = null;
        try {
            in = imgFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //使用SFTPUtils工具类上传图片到服务器
        SFTPUtils sftpUtils = new SFTPUtils(username, password, host, port);
        sftpUtils.login();
        try {
            sftpUtils.upload(uploadPath,newName, in);
            String url = serverUtl + newName;
            map.put("error",0);
            map.put("url",url);
        } catch (SftpException e) {
            map.put("error",1);
            map.put("message","目录不存在！");
            e.printStackTrace();
        }
        sftpUtils.logout();
        return map;
    }
}
