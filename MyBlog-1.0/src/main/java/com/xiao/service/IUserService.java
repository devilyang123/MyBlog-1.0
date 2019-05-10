package com.xiao.service;

import com.xiao.entity.User;

/**
 * @Description 用户service层接口
 * @Auther: 笑笑
 * @Date: 23:03 2018/9/28
 */
public interface IUserService {

    /**
     * @Description 保存用户
     * @Auther: 笑笑
     * @Date: 23:08 2018/9/28
     */
     boolean save(User user);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
     User findByUserName(String userName);


    /**
     * @Description 激活用户
     * @Auther: 笑笑
     * @Date: 23:30 2019/1/16
     */
    boolean activeUser(User user);
}
