package com.xiao.config;

import com.xiao.entity.User;
import com.xiao.exception.AccountUnActiveException;
import com.xiao.repository.UserReposiory;
import com.xiao.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description Realm
 * @Auther: 笑笑
 * @Date: 19:32 2018/9/24
 */
//如果仅仅需要认证，继承此类即可
//public class ShiroRealm extends AuthenticatingRealm {

//继承下面这个类 可以认证 和授权
@Component
public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    private IUserService userService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        //1.把authenticationToken转换成UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //2.从UsernamePasswordToken获取userName
        String userName = token.getUsername();
        //3.根据userName查询数据库
        User user = userService.findByUserName(userName);

        //4.若用户不存在 则抛出未知用户异常
        if(user == null){
            throw new UnknownAccountException("登录失败:用户不存在！");
        }
        //判断用户是否激活
        if(user.getActiveCode() == 0){
            throw new AccountUnActiveException("登录失败:用户未激活！");
        }
        //5.根据用户信息的情况 决定是否需要抛出其他的异常

        //6.根据用户的情况构建AuthenticationInfo 对象 并返回,以下信息是从数据库中获取的
        //参数1,认证的实体信息，可以使userName，也可以是数据表对应的实体类对象
        //参数2,数据库表中获取的密码
        //参数3，加盐，一般使用随机字符串或userName、userID
        //参数4,当前realm对象的name,调用父类的getName()方法即可
        //new SimpleAuthenticationInfo(principal, credentials, realmName);这个不能加盐
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(),ByteSource.Util.bytes(user.getUserName()),  getName());
        return info;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1.从PrincipalCollection 中获取登录用户的信息
        Object principal = principals.getPrimaryPrincipal();
        //2.利用用户信息来查询它所具有的角色和权限（可能本来就包含，也可能要去查询数据库）
        //手动设置角色
        Set<String> roles = new HashSet<>();
        roles.add("user");//如果普通用户登录，只有user角色
        if("admin".equals(principal)){//如果登录人是admin,添加admin角色
            roles.add("admin");
        }
        //3.创建SimpleAuthorizationInfo，并设置其属性，roles
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        //4.返回创建SimpleAuthorizationInfo 对象
        return info;
    }


    //查看加密后的字符串
    public static void main(String[] args){
        String hashAlgorithmName = "MD5"; //也可以用SHA1加密算法
        Object credentials = "123";
        Object salt = ByteSource.Util.bytes("abcd");
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}
