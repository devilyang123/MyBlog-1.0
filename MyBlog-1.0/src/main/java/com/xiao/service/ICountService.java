package com.xiao.service;

import com.xiao.entity.Count;

/**
 * @Description 博客总访问量service层接口
 * @Auther: 笑笑
 * @Date: 10:48 2018/10/2
 */
public interface ICountService {


    /**
     * @Description 根据id查访问量
     * @Date 10:50 2018/10/2
     * @Param
     * @return
     */
    Count getOne(Long countId);

    /**
     * @Description 保存访问量
     * @Date 10:52 2018/10/2
     * @Param
     * @return
     */
     boolean save(Count count);
}
