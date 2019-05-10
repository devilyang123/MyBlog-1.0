package com.xiao.repository;

import com.xiao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description 用户dao
 * @Auther: 笑笑
 * @Date: 10:45 2018/9/25
 */
public interface UserReposiory extends JpaRepository<User,Long> {

    public User findByUserName(String userName);

}
