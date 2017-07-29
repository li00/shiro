package com.lzf.shiro.controller;

import com.lzf.shiro.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/7/24.
 */
@Controller
@RequestMapping("/shiro")
public class ShiroController {
    @Autowired
    private ShiroService shiroService;
    @PostMapping(value = "/login")
    public String login(String username, String pwd){
        System.out.println(username+pwd);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            //把用户名密码封装为UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username,pwd);
            token.setRememberMe(true);
            try {
                //执行登陆
                subject.login(token);
            }catch (Exception e){
                System.out.println("登陆失败");
                return "login";
            }
        }
        return "success";
    }

    @GetMapping(value = "/shiroservice")
    public String shiroService(HttpSession session){
        session.setAttribute("user","admin");
        shiroService.method();
        return "redirect:/page/success.jsp";
    }
}
