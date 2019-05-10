package com.xiao.Utils;

import com.xiao.common.TableResult;
import com.xiao.enums.CommonEnum;
import org.springframework.data.domain.Page;

/**
 * @Description layui表格最外层返回对象 封装工具类
 * @Auther: 笑笑
 * @Date: 16:18 2018/10/19
 */
public class TableResultUtils {

    public static TableResult result(Page page,TableResult result){
        if (page.getContent() != null || page.getContent().size() > 0 ){
            result.setCode(CommonEnum.LAYUI_SUCCESS.getCode());
            result.setMsg(CommonEnum.LAYUI_SUCCESS.getMsg());
            result.setCount((int) page.getTotalElements());
            result.setData(page.getContent());
            return result;
        }
        result.setCode(CommonEnum.LAYUI_NO_DATA.getCode());
        result.setMsg(CommonEnum.LAYUI_NO_DATA.getMsg());
        result.setCount(CommonEnum.ZERO.getCode());
        return result;
    }
}
