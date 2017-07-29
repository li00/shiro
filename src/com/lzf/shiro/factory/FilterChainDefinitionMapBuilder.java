package com.lzf.shiro.factory;

import java.util.LinkedHashMap;

/**
 * 初始化权限视图 最好放入数据库
 * Created by lzf on 2017/7/28.
 */
public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String,String> filterChainDefinitionMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        /*模拟数据库数据*/
        map.put("/page/login.jsp","anon");
        map.put("/page/admin.jsp","authc,roles[admin]");
        map.put("/page/user.jsp","authc,roles[user]");
        map.put("/shiro/login","anon");
        map.put("/shiro/logout","logout");
        map.put("/*/*","authc");
        return map;
    }
}
