package com.z.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project--community.
 * Create by zfl on 2020/2/11 13:28.
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubUser {

    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
