package com.z.community.controller;

import com.z.community.dto.AccessTokenDTO;
import com.z.community.dto.GithubUser;
import com.z.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

/**
 * project--community.
 * Create by zfl on 2020/2/10 20:47.
 **/
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    /*
    * @Value("${github.client.id}")：获取配置文件里面key=github.client.id的值
    * */
    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String client_secret;

    @Value("${github.redirect.uri}")
    private String redirect_uri;

    @GetMapping("/callback")
    public String callback(
            @RequestParam(name="code")String code,
            @RequestParam(name = "state")String state
    ){
        String accessToken = githubProvider.getAccessToken(
                new AccessTokenDTO("clientId", "client_secret", code,
                        "redirect_uri", state))
                ;
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
