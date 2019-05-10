package com.xiao.service;

import com.xiao.common.TableResult;
import com.xiao.entity.User;

/**
 * @Description 后台管理 用户service层接口
 * @Auther: 笑笑
 * @Date: 11:06 2018/10/18
 */
public interface IAdminUserService {

    /**
     * 分页查询用户
     * @param page
     * @param limit
     * @return
     */
    TableResult<User> findAll(Integer page,Integer limit);

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    User getOne(Long userId);
}
