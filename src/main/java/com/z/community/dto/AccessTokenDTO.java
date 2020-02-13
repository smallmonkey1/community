package com.z.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project--community.
 * Create by zfl on 2020/2/11 12:44.
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;


}
