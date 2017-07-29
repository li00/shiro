package com.lzf.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/24.
 */
public class ShiroRealm extends AuthorizingRealm {

    /*认证方法*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo"+token);
        //1,把 AuthenticationToken转化为UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //2.从UsernamePasswordToken中获取username
        String usename = upToken.getUsername();
        //3.调用数据库方法，获取数据库的usename数据
        String pwd = "123";
        //4.若用户不存在，抛出UnknownAccountException
        if("unknown".equals(usename)){
            throw new UnknownAccountException("用户不存在");
        }
        //5.根据用户实际情况是否抛出AuthenticationException
        if("monster".equals(usename)){
            throw new LockedAccountException("用户被锁定");
        }
        //6.根据用户情况，构建AuthenticationInfo，并返回对象
        //第一个参数是对象，第二个是数据库中获取的密码，第三个是角色名
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(usename,pwd,getName());
        return info;
    }

    /*授权方法*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        //1.从PrincipalCollection中获取用户登录信息
        Object principal =  collection.getPrimaryPrincipal();
        //2.你用登录的用户信息来查询用户权限和角色（可能从数据库中查询）
        Set<String> roles = new HashSet<>();
        roles.add("user");
        if("admin".equals(principal)){
            roles.add("admin");
        }
        //3.创建SimpleAuthorizationInfo,并设置roles属性
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        //4.返回SimpleAuthorizationInfo对象
        return info;
    }
}
