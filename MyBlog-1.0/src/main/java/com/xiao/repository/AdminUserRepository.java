package com.xiao.repository;

import com.xiao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description 后台管理 用户dao层接口
 * @Auther: 笑笑
 * @Date: 11:05 2018/10/18
 */
public interface AdminUserRepository extends JpaRepository<User,Long> {

    @Override
    Page<User> findAll(Pageable pageable);
}
