package com.xiao.Utils;

import com.xiao.common.PageResult;
import com.xiao.enums.CommonEnum;
import org.springframework.data.domain.Page;

/**
 * @Description 分页返回工具类
 * @Auther: 笑笑
 * @Date: 16:26 2018/9/30
 */
public class PageResultUtils {


    public static PageResult result(Page page,PageResult result ){
        if(page.getContent() != null && page.getContent().size() > 0){
            result.setCode(CommonEnum.SUCCESS.getCode());
            result.setMsg(CommonEnum.SUCCESS.getMsg());
            result.setCount((int) page.getTotalElements());
            result.setTotalPages(page.getTotalPages());
            result.setData(page.getContent());
            return result;
        }
        result.setCode(CommonEnum.NONE.getCode());
        result.setMsg(CommonEnum.NONE.getMsg());
        return result;
    }
}
