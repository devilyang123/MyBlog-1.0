package com.xiao.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * @Description 分页查询返回最外层对象
 * @Auther: 笑笑
 * @Date: 15:31 2018/9/30
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResult<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码信息
     */
    private String msg;

    /**
     * 总数
     */
    private Integer count;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 返回数据
     */
    private List<T> data;

}
