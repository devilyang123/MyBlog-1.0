package com.xiao.repository;

import com.xiao.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description 评论dao层接口
 * @Auther: 笑笑
 * @Date: 15:15 2018/10/8
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findCommentByBlogId(Long blogId,Sort sort);
}
