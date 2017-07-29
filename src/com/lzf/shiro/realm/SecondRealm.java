package com.lzf.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Administrator on 2017/7/25.
 */
public class SecondRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1,把 AuthenticationToken转化为UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //2.从UsernamePasswordToken中获取username
        String usename = upToken.getUsername();
        //3.调用数据库方法，获取数据库的usename数据
        String uname = "张三";
        String pwd = "123";
        //4.若用户不存在，抛出UnknownAccountException
        if ("unknown".equals(usename)) {
            throw new UnknownAccountException("用户不存在");
        }
        //5.根据用户实际情况是否抛出AuthenticationException
        if ("monster".equals(usename)) {
            throw new LockedAccountException("用户被锁定");
        }
        //6.根据用户情况，构建AuthenticationInfo，并返回对象
        ByteSource salt = ByteSource.Util.bytes(usename);
        System.out.println(salt);
        //第一个参数是对象，第二个是数据库中获取的密码，第三个是角色名
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(usename, pwd, salt, getName());
        return info;
    }
}
