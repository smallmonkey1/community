package com.z.community.dto;

import lombok.Data;

/**
 * project--community.
 * Create by zfl on 2020/2/17 23:21.
 **/
@Data
public class CommentCreateDTO {

    private Long parentId;
    private String content;
    private Integer type;
}
