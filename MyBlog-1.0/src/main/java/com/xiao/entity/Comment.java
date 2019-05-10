package com.xiao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description 评论实体类
 * @Auther: 笑笑
 * @Date: 14:36 2018/10/8
 */
@Data
@Entity(name = "tb_comment")
public class Comment {

    /**
     * 评论Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 博客Id（该评论属于哪个博客）
     */
    private Long blogId;

    /**
     * 发表时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
