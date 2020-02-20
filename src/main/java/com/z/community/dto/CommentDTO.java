package com.z.community.dto;

import com.z.community.model.User;
import lombok.Data;

/**
 * project--community.
 * Create by zfl on 2020/2/19 17:24.
 **/
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private Integer commentCount;
    private User user;
}
