package com.xiao.repository;

import com.xiao.entity.Count;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description 博客总访问量dao接口
 * @Auther: 笑笑
 * @Date: 10:46 2018/10/2
 */
public interface CountRepository extends JpaRepository<Count,Long> {


}
