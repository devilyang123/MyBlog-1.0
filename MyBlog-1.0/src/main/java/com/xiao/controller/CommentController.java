package com.xiao.controller;

import com.xiao.entity.Comment;
import com.xiao.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 评论相关controller
 * @Auther: 笑笑
 * @Date: 15:24 2018/10/8
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    /**
     * @Description 保存评论
     * @Date 16:43 2018/10/8
     * @Param
     * @return
     */
    @PostMapping(value = "/save")
    public boolean save(Comment comment){
        return commentService.save(comment);
    }

    /**
     * @Description 根据博客Id获取对应的评论
     * @Date 15:13 2018/10/10
     * @Param
     * @return
     */
    @GetMapping(value = "/findComments")
    public List<Comment> findComments(Long blogId){
        return commentService.findCommentByBlogId(blogId);
    }
}
