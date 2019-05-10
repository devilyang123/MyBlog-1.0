package com.xiao.common;

import lombok.Data;

import java.util.List;

/**
 * @Description layui 表格最外层返回对象
 * @Auther: 笑笑
 * @Date: 15:25 2018/10/17
 */
@Data
public class TableResult<T> {

    private Integer code ;//成功状态码 默认要为0

    private String msg ;

    private Integer count;

    private List<T> data;
}
