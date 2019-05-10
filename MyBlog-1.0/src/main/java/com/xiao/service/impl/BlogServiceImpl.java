package com.xiao.service.impl;

import com.xiao.Utils.PageResultUtils;
import com.xiao.common.PageResult;
import com.xiao.entity.Blog;
import com.xiao.enums.CommonEnum;
import com.xiao.repository.BlogRepository;
import com.xiao.repository.CategoryRepository;
import com.xiao.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @Description 博客service层接口实现类
 * @Auther: 笑笑
 * @Date: 10:55 2018/9/27
 */
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * @Description 保存博客
     * @Date 10:59 2018/9/27
     * @Param
     * @return
     */
    @Override
    public boolean save(Blog blog) {
        Date date = new Date();
        blog.setCreateTime(date);
        blog.setUpdateTime(date);
        blog.setCategoryName(categoryRepository.findCategoryByCategoryId(blog.getCategoryId()).getName());
        Blog result = blogRepository.save(blog);
        if(result != null){
            return true;
        }
        return false;
    }

    /**
     * @Description 根据博客ID查询博客
     * @Date 22:47 2018/9/28
     * @Param
     * @return
     */
    @Override
    public Blog getOne(Long blogId) {
        Blog blog = blogRepository.getOne(blogId);
        if (blog != null){
            Integer readNum = blog.getReadNum();
            readNum += 1;
            blog.setReadNum(readNum);
            blogRepository.save(blog);
            return blog;
        }
        return null;
    }

    /**
     * @Description 分页查询博客
     * @Date 17:04 2018/9/29
     * @Param
     * @return
     */
    @Override
    public PageResult<Blog> findAll(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");//按时间降序排列
        PageRequest request = PageRequest.of(page-1,size,sort);//因为是从0开始，页面初始传的是1，所以减1
        Page<Blog> blogs = blogRepository.findAllByLogicEquals(CommonEnum.LOGIC_NORMAL.getCode(),request);
        PageResult<Blog> result = new PageResult<>();
        PageResultUtils.result(blogs,result);
        return result;
    }
    /**
     * @Description 查询所有博客(用于统计博客总数)
     * @Date 11:29 2018/10/2
     * @Param
     * @return
     */
    @Override
    public List<Blog> findAll() {
        List<Blog> blogList = blogRepository.findAll();
        if(blogList != null && blogList.size() > 0){
            return  blogList;
        }
        return null;
    }

    /**
     * @Description 查询热门博客(按阅读量)
     * @Date 10:39 2018/10/9
     * @Param
     * @return
     */
    @Override
    public PageResult<Blog> findHotBlog() {
        Sort sort = new Sort(Sort.Direction.DESC,"readNum");//按阅读量降序排列
        PageRequest request = PageRequest.of(0,6,sort);//第一页从开始，每页显示6条记录，在这里写死了
        Page<Blog> blogs = blogRepository.findAllByLogicEquals(CommonEnum.LOGIC_NORMAL.getCode(),request);
        PageResult<Blog> result = new PageResult<>();
        PageResultUtils.result(blogs,result);
        return result;
    }

    /**
     * @Description 查询置顶博客
     * @Date 15:16 2018/10/18
     * @Param
     * @return
     */
    @Override
    public Blog findTopBlog() {
        return blogRepository.findBlogByIsTopEqualsAndLogicEquals(CommonEnum.TOP_BLOG.getCode(),CommonEnum.LOGIC_NORMAL.getCode());
    }

    /**
     * @Description 修改博客
     * @Date 17:16 2018/10/23
     * @Param
     * @return
     */
    public boolean editBlog(Blog blog){
        Blog b = blogRepository.getOne(blog.getBlogId());
        b.setTitle(blog.getTitle());
        b.setCategoryId(blog.getCategoryId());
        b.setCategoryName(categoryRepository.findCategoryByCategoryId(blog.getCategoryId()).getName());
        if(blog.getImgUrl() != null){
            b.setImgUrl(blog.getImgUrl());
        }
        b.setSummary_(blog.getSummary_());
        b.setContent(blog.getContent());
        b.setUpdateTime(new Date());
        Blog result = blogRepository.save(b);
        if (result != null){
            return true;
        }
        return false;
    }
}
