package com.xiao.controller;

import com.xiao.Utils.JsonUtils;
import com.xiao.common.TableResult;
import com.xiao.entity.Blog;
import com.xiao.entity.Count;
import com.xiao.enums.CommonEnum;
import com.xiao.service.IAdminBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * @Description 后台管理 博客controller
 * @Auther: 笑笑
 * @Date: 10:32 2018/10/18
 */
@Slf4j
@RestController
@RequestMapping(value = "/admin/blog")
public class AdminBlogController {

    @Autowired
    private IAdminBlogService adminBlogService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @Description 分页查询博客
     * @Date 10:34 2018/10/18
     * @Param
     * @return
     */
    @GetMapping(value = "/findAll")
    public TableResult<Blog> findAll(Integer page,Integer limit){
        return adminBlogService.findAll(page,limit);
    }

    /**
     * @Description 置顶博客
     * @Date 9:51 2018/10/19
     * @Param
     * @return
     */
    @GetMapping(value = "/topBlog")
    public Map<String,Object> topBlog(Long blogId){
        Map<String,Object> map = new HashMap<>();
        List<Blog> blogList = adminBlogService.findBlobByIsTop(CommonEnum.TOP_BLOG.getCode());
        //如果size等于1，表示有博客置顶，不允许再置顶博客
        if (blogList.size() == 1){
            map.put("result",CommonEnum.TOP_BLOG.getCode());//在页面判断，如果result为1，表示有文章置顶
            map.put("msg","已存在置顶文章");
            return map;
        }else{
            Blog blog = adminBlogService.getOne(blogId);
            if(blog.getLogic() == 1){
                map.put("result","delete");
                map.put("msg","该文章已删除，不能置顶");
                return map;
            }
            blog.setIsTop(CommonEnum.TOP_BLOG.getCode());
            boolean result = adminBlogService.save(blog);
            if(result){
                map.put("result",result);
                map.put("msg","置顶文章成功");
                //将置顶的文章放入redis缓存
                redisTemplate.opsForValue().set("topBlog",JsonUtils.objectToJson(blog));
                return map;
            }
            map.put("result",result);
            map.put("msg","置顶文章失败");
            return map;
        }
    }

    /**
     * @Description 取消置顶博客
     * @Auther: 笑笑
     * @Date: 10:40 2018/10/19
     */
    @GetMapping(value = "/cancelTopBlog")
    public boolean cancelTopBlog(Long blogId){
        Blog blog = adminBlogService.getOne(blogId);
        blog.setIsTop(CommonEnum.NO_TOP_BLOG.getCode());
        log.info("取消置顶文章，清除置顶文章缓存！");
        redisTemplate.delete("topBlog");
        return  adminBlogService.save(blog);
    }

    /**
     * @Description 逻辑删除博客
     * @Auther: 笑笑
     * @Date: 10:08 2018/10/25
     */
    @GetMapping(value = "/logicDeleteBlog")
    public boolean logicDeleteBlog(Long blogId){
        Blog blog = adminBlogService.getOne(blogId);
        blog.setLogic(CommonEnum.LOGIC_DELETE.getCode());
        Set<String> blogListKeys = redisTemplate.keys("blog*");
        log.info("逻辑删除文章，清除文章分页缓存！");
        redisTemplate.delete(blogListKeys);
        Set<String> hotBlogListKeys = redisTemplate.keys("hot*");
        log.info("逻辑删除文章，清除热门文章缓存！");
        redisTemplate.delete(hotBlogListKeys);
        log.info("逻辑删除文章，清除置顶文章缓存！");
        redisTemplate.delete("topBlog");
        return adminBlogService.save(blog);
    }

    /**
     * @Description 恢复逻辑删除的博客
     * @Auther: 笑笑
     * @Date: 10:19 2018/10/25
     */
    @GetMapping(value = "/recoverBlog")
    public boolean recoverBlog(Long blogId){
        Blog blog = adminBlogService.getOne(blogId);
        blog.setLogic(CommonEnum.LOGIC_NORMAL.getCode());
        Set<String> blogListKeys = redisTemplate.keys("blog*");
        log.info("恢复删除文章，清除文章分页缓存！");
        redisTemplate.delete(blogListKeys);
        Set<String> hotBlogListKeys = redisTemplate.keys("hot*");
        log.info("恢复删除文章，清除热门文章缓存！");
        redisTemplate.delete(hotBlogListKeys);
        log.info("恢复删除文章，清除置顶文章缓存！");
        redisTemplate.delete("topBlog");
        return adminBlogService.save(blog);
    }

    /**
     * @Description 查询总访问量
     * @Date 11:42 2018/11/6
     * @Param
     * @return
     */
    @GetMapping(value = "/getCount")
    public Map<String,Object> getCount(){
        Count count = adminBlogService.getCount();
        Map<String,Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        list.add(count.getCount());
        map.put("count",list);
        return map;
    }
}
