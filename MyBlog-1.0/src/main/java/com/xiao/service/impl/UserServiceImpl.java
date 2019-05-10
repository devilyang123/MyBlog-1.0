package com.xiao.service.impl;

import com.xiao.Utils.Md5AndSaltUtil;
import com.xiao.entity.User;
import com.xiao.repository.UserReposiory;
import com.xiao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description 用户service层接口实现类
 * @Auther: 笑笑
 * @Date: 23:04 2018/9/28
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserReposiory userReposiory;

    /**
     * @Description 保存用户
     * @Auther: 笑笑
     * @Date: 23:10 2018/9/28
     */
    @Override
    public boolean save(User user) {
        Object md5AndSaltPassword = Md5AndSaltUtil.getMd5AndSaltPassword(user.getUserName(), user.getPassword());
        user.setPassword(md5AndSaltPassword.toString());
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        User u = userReposiory.save(user);
        if(u != null){
            return true;
        }
        return  false;
    }
    /**
     * @Description 根据用户名查询用户
     * @Date 23:05 2018/9/28
     * @Param
     * @return
     */
    @Override
    public User findByUserName(String userName) {
        User user = userReposiory.findByUserName(userName);
        if (user !=null){
            return user;
        }
        return null;
    }

    @Override
    public boolean activeUser(User user) {
        User u = userReposiory.save(user);
        if(u!=null){
            return true;
        }
        return false;
    }
}
