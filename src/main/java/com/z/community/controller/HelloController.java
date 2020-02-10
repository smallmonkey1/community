package com.z.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * project--community.
 * Create by zfl on 2020/2/10 15:00.
 **/
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name",required = false,defaultValue = "world")String name,
            Model model
            ){
        model.addAttribute("name",name);
        return "hello";
    }
}
