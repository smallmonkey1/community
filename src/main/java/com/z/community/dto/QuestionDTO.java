package com.z.community.dto;

import com.z.community.model.User;
import lombok.Data;

/**
 * project--community.
 * Create by zfl on 2020/2/13 15:12.
 **/
@Data
public class QuestionDTO {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
