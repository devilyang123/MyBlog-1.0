package com.xiao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Description 用户实体类
 * @Auther: 笑笑
 * @Date: 10:39 2018/9/25
 */

@Data
@Entity(name = "tb_user")
//@Table(uniqueConstraints = {
//        @UniqueConstraint(columnNames = "userName",name = "uq_user_name"),
//        @UniqueConstraint(columnNames = "password",name = "uq_password")
//})
public class User {

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 用户名
     */
//    @NotNull
    @Column(nullable = false,unique = true)
    private String userName;

    /**
     * 密码
     */
//    @NotNull
    @Column(nullable = false,unique = true)
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像地址
     */
    private String imgUrl;

    /**
     * 性别 0-男 1-女
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private Date born;

    /**
     * 自我描述，简介
     */
    private String Desc_;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 激活状态 默认0未激活，1已激活
     */
    private Integer activeCode = 0;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
