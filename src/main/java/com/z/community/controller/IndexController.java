package com.z.community.controller;

import com.z.community.mapper.UserMapper;
import com.z.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * project--community.
 * Create by zfl on 2020/2/10 18:14.
 **/
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String Index(
            HttpServletRequest req
    ){
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user=userMapper.findByToken(token);
                System.out.println("这是我的user====" + user);
                if(user!=null){
                    req.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }

}
