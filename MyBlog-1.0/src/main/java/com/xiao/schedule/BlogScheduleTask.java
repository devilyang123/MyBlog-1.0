package com.xiao.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Description 博客相关定时任务
 * @Auther: 笑笑
 * @Date: 10:55 2018/10/15
 */
@Component
@Slf4j
public class BlogScheduleTask {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //秒、分、时、日、月、周  年（可选)
    @Scheduled(cron = "0 0 0 * * ?")
    public void clearRedis(){
        //清空redis文章分页数据缓存
        Set<String> blogListKeys = redisTemplate.keys("blog*");
        redisTemplate.delete(blogListKeys);

        //清除redis热门文章缓存
        Set<String> hotBlogListKeys = redisTemplate.keys("hot*");
        redisTemplate.delete(hotBlogListKeys);

        //清除redis置顶文章缓存
        redisTemplate.delete("topBlog");

       log.info("定时任务，清除文章缓存！");
    }
}
