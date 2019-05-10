package com.xiao.service.impl;

import com.xiao.Utils.TableResultUtils;
import com.xiao.common.TableResult;
import com.xiao.entity.User;
import com.xiao.repository.AdminUserRepository;
import com.xiao.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description 后台管理 用户service层接口实现类
 * @Auther: 笑笑
 * @Date: 11:08 2018/10/18
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    /**
     * @Description 分页查询用户
     * @Date 11:09 2018/10/18
     * @Param
     * @return
     */
    @Override
    public TableResult<User> findAll(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page-1,limit);
        Page<User> users = adminUserRepository.findAll(pageable);
        TableResult<User> result = new TableResult<>();
        TableResultUtils.result(users,result);
        return result;
    }

    /**
     * @Description 根据用户ID查询用户
     * @Date 15:41 2018/10/26
     * @Param
     * @return
     */
    @Override
    public User getOne(Long userId) {
        User user = adminUserRepository.getOne(userId);
        if(user != null){
            return user;
        }
        return null;
    }
}
