package com.xiao.Utils;

import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description 博客图片上传工具类
 * @Auther: 笑笑
 * @Date: 8:46 2018/10/25
 */
@Slf4j
public class UploadUtils {

    @Value("${upload.path}")
    private static String uploadPath; //读取配置文件中上传图片路径

    @Value("${upload.host}")
    private static String host;     //sftp主机ip

    @Value("${upload.username}")
    private static String username; //用户名

    @Value("${upload.password}")
    private static String password; //密码

    @Value("${upload.port}")
    private static int  port;    //sftp上传端口


    public static void upload(MultipartFile imgFile,String newName) {

        //获取文件输入流
        InputStream in = null;
        try {
            in = imgFile.getInputStream();
        } catch (IOException e) {
            log.error("获取图片输入流失败！");
            e.printStackTrace();
        }
        //使用SFTPUtils工具类上传图片到服务器
        SFTPUtils sftpUtils = new SFTPUtils(username, password, host, port);
        sftpUtils.login();
        try {
            sftpUtils.upload(uploadPath,newName, in);
            log.info("上传文章图片成功！");
        } catch (SftpException e) {
            log.error("上传文章图片失败！");
            e.printStackTrace();
        }
        sftpUtils.logout();
    }
}


