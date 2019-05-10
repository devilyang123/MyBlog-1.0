package com.xiao.service.impl;

import com.xiao.entity.Blog;
import com.xiao.entity.Comment;
import com.xiao.repository.BlogRepository;
import com.xiao.repository.CommentRepository;
import com.xiao.service.ICommentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @Description 评论service层接口实现类
 * @Auther: 笑笑
 * @Date: 15:18 2018/10/8
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;


    /**
     * @Description 保存评论
     * @Date 15:18 2018/10/8
     * @Param
     * @return
     */
    @Override
    public boolean save(Comment comment) {

        Subject subject = SecurityUtils.getSubject();
        comment.setUserName((String)subject.getPrincipal());
        comment.setCreateTime(new Date());
        Comment result = commentRepository.save(comment);
        Blog blog = blogRepository.getOne(comment.getBlogId());
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");//按时间降序排列
        List<Comment> commentList = commentRepository.findCommentByBlogId(comment.getBlogId(),sort);
        blog.setComments(commentList.size());//保存评论数量
        blogRepository.save(blog);//更新数据
        if(result != null){
            return true;
        }
        return false;
    }

    /**
     * @Description 根据博客Id查询对应的评论列表
     * @Date 16:41 2018/10/8
     * @Param
     * @return
     */
    @Override
    public List<Comment> findCommentByBlogId(Long blogId) {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        List<Comment> commentList = commentRepository.findCommentByBlogId(blogId,sort);
        return commentList;
    }
}
