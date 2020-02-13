package com.z.community.provider;

import com.alibaba.fastjson.JSON;
import com.z.community.dto.AccessTokenDTO;
import com.z.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * project--community.
 * Create by zfl on 2020/2/11 12:41.
 **/
@Component
public class GithubProvider {


    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType  = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String s1 = response.body().string();
            String token = s1.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String s1 = response.body().string();
            GithubUser githubUser = JSON.parseObject(s1, GithubUser.class);
            return githubUser;
        } catch (IOException e) {

        }
        return null;
    }
}
