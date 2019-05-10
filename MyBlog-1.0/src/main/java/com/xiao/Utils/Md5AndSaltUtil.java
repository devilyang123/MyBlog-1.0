package com.xiao.Utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description shiro MD5加密 加盐 工具类
 * @Auther: 笑笑
 * @Date: 11:22 2018/9/25
 */
public class Md5AndSaltUtil {

    public static Object getMd5AndSaltPassword(String userName,String password){
        String hashAlgorithmName = "MD5";
        Object credentials = password;
        Object salt =ByteSource.Util.bytes(userName);
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        return  result;
    }
}
