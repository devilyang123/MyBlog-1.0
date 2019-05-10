package com.xiao.enums;

import lombok.Getter;

/**
 * @Description 公用信息枚举类
 * @Auther: 笑笑
 * @Date: 16:34 2018/9/30
 */
@Getter
public enum CommonEnum {

     LAYUI_SUCCESS(0,"成功")
    ,LAYUI_NO_DATA(1,"无数据")
    ,SUCCESS(200,"成功")
    ,NONE(9999,"无数据")
    ,TOP_BLOG(1,"置顶")//置顶博客标识码
    ,NO_TOP_BLOG(0,"不置顶")//不置顶博客标识码
    ,ZERO(0,"零")
    ,ONE(1,"一")
    ,LOGIC_NORMAL(0,"正常")
    ,LOGIC_DELETE(1,"删除")
    ;

    private Integer code;

    private String msg;

    CommonEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
