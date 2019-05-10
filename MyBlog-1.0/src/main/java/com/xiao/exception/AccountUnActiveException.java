package com.xiao.exception;


import org.apache.shiro.authc.AuthenticationException;

/**
 * @Description 用户未激活异常类
 * @Auther: 笑笑
 * @Date: 15:43 2018/10/11
 */
public class AccountUnActiveException extends AuthenticationException {

    public  AccountUnActiveException(String message){
        super(message);
    }
}
