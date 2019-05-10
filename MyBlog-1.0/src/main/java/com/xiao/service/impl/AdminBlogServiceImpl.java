package com.xiao.service.impl;

import com.xiao.Utils.TableResultUtils;
import com.xiao.common.TableResult;
import com.xiao.entity.Blog;
import com.xiao.entity.Count;
import com.xiao.repository.AdminBlogRepository;
import com.xiao.repository.CountRepository;
import com.xiao.service.IAdminBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description 后台管理 博客service层接口实现类
 * @Auther: 笑笑
 * @Date: 10:25 2018/10/18
 */
@Service
public class AdminBlogServiceImpl implements IAdminBlogService {

    @Autowired
    private AdminBlogRepository adminBlogRepository;

    @Autowired
    private CountRepository countRepository;

    /**
     * @Description 分页查询博客
     * @Date 10:26 2018/10/18
     * @Param
     * @return
     */
    @Override
    public TableResult<Blog> findAll(Integer page, Integer limit) {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");//按时间降序排列
        Pageable pageable = PageRequest.of(page-1,limit,sort);
        Page<Blog> blogs = adminBlogRepository.findAll(pageable);
        TableResult<Blog> result = new TableResult<>();
        TableResultUtils.result(blogs,result);
        return result;
    }

    /**
     * @Description 保存、更新博客
     * @Date 9:46 2018/10/19
     * @Param
     * @return
     */
    @Override
    public boolean save(Blog blog) {
        Blog result = adminBlogRepository.save(blog);
        if(result != null){
            return true;
        }
        return false;
    }

    /**
     * @Description 根据ID查询博客
     * @Date 9:46 2018/10/19
     * @Param
     * @return
     */
    @Override
    public Blog getOne(Long blogId) {
        Blog blog = adminBlogRepository.getOne(blogId);
        if (blog != null){
            return blog;
        }
        return null;
    }

    /**
     * @Description 根据置顶标识查询博客列表
     * @Date 11:16 2018/10/19
     * @Param
     * @return
     */
    @Override
    public List<Blog> findBlobByIsTop(Integer isTop) {
        return adminBlogRepository.findBlogByIsTopEquals(isTop);
    }

    /**
     * @Description 查询总访问量
     * @Date 11:31 2018/11/6 
     * @Param 
     * @return 
     */
    @Override
    public Count getCount() {
        Count count = countRepository.getOne(1L);
        if(count != null){
            return count;
        }
        return null;
    }
}
