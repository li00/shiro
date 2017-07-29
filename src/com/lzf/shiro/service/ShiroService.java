package com.lzf.shiro.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;

/**
 * shiro注解
 * Created by lzf on 2017/7/28.
 */
public class ShiroService {
    @RequiresRoles({"admin"})
    public void method(){
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println(session);
        System.out.println("shiroService..........");
    }
}
