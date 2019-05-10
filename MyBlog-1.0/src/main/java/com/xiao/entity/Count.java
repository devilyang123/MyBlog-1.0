package com.xiao.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description 博客总访问量实体类
 * @Auther: 笑笑
 * @Date: 10:43 2018/10/2
 */
@Data
@Entity(name = "tb_count")
public class Count {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countId;
    /**
     * 总访问量
     */
    private Long count;
}
