package com.z.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * project--community.
 * Create by zfl on 2020/2/10 18:14.
 **/
@Controller
public class IndexController {


    @GetMapping("/index")
    public String Index(){
        return "index";
    }
}
