package com.xiao.common;

import lombok.Data;
import java.util.List;

/**
 * @Description 小程序  数据返回最外层对象
 * @Auther: 笑笑
 * @Date: 9:24 2018/10/29
 */
@Data
public class AppResult<T> {

    private Integer code;

    private String msg;

    private Long count;

    private List<T> data;
}
