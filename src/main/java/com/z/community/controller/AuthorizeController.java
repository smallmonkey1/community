package com.z.community.controller;

import com.z.community.dto.AccessTokenDTO;
import com.z.community.dto.GithubUser;
import com.z.community.model.User;
import com.z.community.provider.GithubProvider;
import com.z.community.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * project--community.
 * Create by zfl on 2020/2/10 20:47.
 **/
@Controller
@Slf4j
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;


    @Autowired
    private UserService userService;

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
            @RequestParam(name = "state")String state,
            HttpServletResponse response
    ){
        String accessToken = githubProvider.getAccessToken(
                new AccessTokenDTO(clientId, client_secret, code,
                        redirect_uri, state))
                ;
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser!=null && githubUser.getId()!=null) {
            User user = new User();
            String cookies = UUID.randomUUID().toString();
            user.setToken(cookies);
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setAvatarUrl(githubUser.getAvatar_url());
            user.setName(githubUser.getName());

            userService.createOrUpdate(user);

            response.addCookie(new Cookie("token",cookies));
            //登录成功，写cookie 和session
            return "redirect:/";

        }else {
            //登录失败，重新登录
            log.error("callback get github error,{}",githubUser);
            return "redirect:/";
        }

    }

    @GetMapping("/logout")
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
