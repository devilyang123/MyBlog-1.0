package com.xiao.controller;


import com.xiao.Utils.MailUtils;
import com.xiao.common.TableResult;
import com.xiao.entity.User;
import com.xiao.enums.CommonEnum;
import com.xiao.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 后台管理 用户controller
 * @Auther: 笑笑
 * @Date: 11:13 2018/10/18
 */
@RestController
@RequestMapping(value = "/admin/user")
public class AdminUserController {

    @Autowired
    private IAdminUserService adminUserService;

    @Autowired
    private MailUtils mailUtils;

    /**
     * 激活链接url前缀
     */
    @Value("${user.active.url.prefix}")
    private String urlPrefix;

    /**
     * @Description 分页查询用户
     * @Date 11:16 2018/10/18
     * @Param
     * @return
     */
    @GetMapping(value = "/findAll")
    public TableResult<User> findAll(Integer page,Integer limit){
        return adminUserService.findAll(page,limit);
    }

    /**
     * @Description 发送激活邮件
     * @Date 15:45 2018/10/26 
     * @Param 
     * @return 
     */
    @GetMapping(value = "/sendActiveEmail")
    public Map<String,Object> sendActiveEmail(Long userId){
        Map<String,Object> map = new HashMap<>();
        User user = adminUserService.getOne(userId);
        if(user.getActiveCode() == 1){
            map.put("result",CommonEnum.ONE.getCode());
            return map;
        }
        String link = "<a target='_blank' style='text-decoration:none;' " +
                "href='"+urlPrefix+"active/"+user.getUserName()+"'>请点击这里进行账号激活</a>";
        mailUtils.sendHtmlMail(user.getEmail(),link);//发送激活邮件
        map.put("result",true);
        return map;
    }
}
