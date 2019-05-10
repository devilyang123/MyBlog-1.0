package com.xiao.common;


import lombok.Data;

/**
 * @Description 返回单个对象数据的包装类
 * @Auther: 笑笑
 * @Date: 9:35 2018/10/23
 */
@Data
public class ObjectResult<T> {

   private T data;
}
