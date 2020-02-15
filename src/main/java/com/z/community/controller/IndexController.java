package com.z.community.controller;

import com.z.community.dto.PaginationDTO;
import com.z.community.mapper.UserMapper;
import com.z.community.model.User;
import com.z.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private QuestionService questionService;


    @GetMapping("/")
    public String Index(
            HttpServletRequest req,
            Model model,
            @RequestParam(name = "page",defaultValue = "1")Integer page,
            @RequestParam(name = "size",defaultValue = "5")Integer size
    ){
        Cookie[] cookies = req.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user=userMapper.findByToken(token);
                    if(user!=null){
                        req.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        PaginationDTO pagination = questionService.list(page, size);

        model.addAttribute("pagination",pagination);
        return "index";
    }

}
