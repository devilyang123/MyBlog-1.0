package com.xiao.controller;


import com.xiao.Utils.JsonUtils;
import com.xiao.Utils.UploadUtils;
import com.xiao.common.PageResult;
import com.xiao.entity.Blog;
import com.xiao.entity.Count;
import com.xiao.service.IBlogService;
import com.xiao.service.ICountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.util.Set;


/**
 * @Description 博客相关controller层
 * @Auther: 笑笑
 * @Date: 11:05 2018/9/27
 */
@Slf4j
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private  IBlogService blogService;

    @Autowired
    private ICountService countService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @Description 保存博客
     * @Auther: 笑笑
     * @Date: 11:09 2018/9/27
     */
    @PostMapping(value = "/saveBlog")
    @ResponseBody
    public boolean saveBlog(Blog blog,MultipartFile imgFile){
        String ext = FilenameUtils.getExtension(imgFile.getOriginalFilename());
        String newName = System.currentTimeMillis()+"."+ext;
        //使用工具类
        UploadUtils.upload(imgFile,newName);
        blog.setImgUrl(newName);
        //清空redis文章分页数据缓存
        Set<String> keys = redisTemplate.keys("blog*");
        log.info("保存文章，清除文章分页缓存！");
        redisTemplate.delete(keys);
        return blogService.save(blog);
    }

    /**
     * @Description 根据博客ID查询博客
     * @Date 22:45 2018/9/28
     * @Param
     * @return
     */
    @GetMapping(value = "/getBlogById/{blogId}")
    public String getBlogById(@PathVariable("blogId") Long blogId , Model model, HttpSession session){
        Count count = countService.getOne((long) 1);
        Long total = (long)0;
        if(blogService.findAll() != null){
            total = (long)blogService.findAll().size();
        }
        Long num = count.getCount();
        session.setAttribute("num",num);     //访问量
        session.setAttribute("total",total);//博客总数
        Blog blog = blogService.getOne(blogId);
        model.addAttribute("blog",blog);
        return "/blog/show";
    }

    /**
     * @Description 分页查询博客
     * @Date 15:38 2018/10/1
     * @Param
     * @return
     */
    @GetMapping(value = "/findAll")
    @ResponseBody
    public PageResult<Blog> findAll(int page, int size){
        String key = "blogList"+page;
        if (redisTemplate.opsForValue().get(key) == null){
            PageResult<Blog> result = blogService.findAll(page, size);
            log.info("文章分页查询：查询数据库");
            redisTemplate.opsForValue().set(key,JsonUtils.objectToJson(result));
            return  result;
        }else{
            String json = redisTemplate.opsForValue().get(key);
            log.info("文章分页查询：查询缓存");
            PageResult pageResult = JsonUtils.jsonToPojo(json, PageResult.class);
            return pageResult;
        }
    }

    /**
     * @Description 查询热门博客（按阅读量）
     * @Date 11:21 2018/10/9
     * @Param
     * @return
     */
    @GetMapping(value = "/findHotBlog")
    @ResponseBody
    public PageResult<Blog> findHotBlog(){
        String key = "hotBlog";
        if(redisTemplate.opsForValue().get(key) == null){
            PageResult<Blog> hotBlog = blogService.findHotBlog();
            log.info("热门文章查询：查询数据库");
            redisTemplate.opsForValue().set(key,JsonUtils.objectToJson(hotBlog));
            return hotBlog;
        }else {
            String json = redisTemplate.opsForValue().get(key);
            log.info("热门文章查询：查询缓存");
            PageResult pageResult = JsonUtils.jsonToPojo(json, PageResult.class);
            return pageResult;
        }
    }

    /**
     * @Description 查询置顶博客
     * @Date 15:22 2018/10/18
     * @Param
     * @return
     */
    @GetMapping(value = "/findTopBlog")
    @ResponseBody
    public Blog findTopBlog(){
        if(redisTemplate.opsForValue().get("topBlog") == null){
            log.info("置顶文章查询：查询数据库");
            //查询出来 放入缓存
            redisTemplate.opsForValue().set("topBlog",JsonUtils.objectToJson(blogService.findTopBlog()));
            return blogService.findTopBlog();
        }else {
            String json = redisTemplate.opsForValue().get("topBlog");
            Blog blog = (Blog) JsonUtils.jsonToPojo(json, Blog.class);
            log.info("置顶文章查询：查询缓存");
            return blog;
        }
    }

    /**
     * @Description 跳转编辑博客页面
     * @Date 15:39 2018/10/23
     * @Param
     * @return
     */
    @GetMapping(value = "/editBlog/{blogId}")
    public String editBlog(@PathVariable("blogId")Long blogId,Model model){
        Blog blog = blogService.getOne(blogId);
        model.addAttribute("blog",blog);
        return "/blog/editPage";
    }

    /**
     * @Description 修改博客
     * @Date 16:53 2018/10/23
     * @Param
     * @return
     */
    @PostMapping(value = "/toEditBlog")
    @ResponseBody
    public boolean toEditBlog(Blog blog,MultipartFile imgFile){
        if(!imgFile.isEmpty()){
            String ext = FilenameUtils.getExtension(imgFile.getOriginalFilename());
            String newName = System.currentTimeMillis()+"."+ext;
            //使用工具类
            UploadUtils.upload(imgFile,newName);
            blog.setImgUrl(newName);
        }
        //清空redis文章分页数据缓存
        Set<String> blogListKeys = redisTemplate.keys("blog*");
        log.info("修改文章，清除文章分页缓存！");
        redisTemplate.delete(blogListKeys);

        //清除redis置顶文章缓存
        log.info("修改文章，清除置顶文章缓存！");
        redisTemplate.delete("topBlog");

       return blogService.editBlog(blog);
    }
}
