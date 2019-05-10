package com.xiao.service;

import com.xiao.entity.Comment;
import java.util.List;


/**
 * @Description 评论service层接口
 * @Auther: 笑笑
 * @Date: 15:16 2018/10/8
 */
public interface ICommentService {

    /**
     * 保存评论
     * @param comment
     * @return
     */
    boolean save(Comment comment);

    /**
     * 根据博客Id查询对应的评论
     * @param blogId
     * @return
     */
    List<Comment> findCommentByBlogId(Long blogId);
}
