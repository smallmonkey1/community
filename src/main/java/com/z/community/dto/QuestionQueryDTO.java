package com.z.community.dto;

import lombok.Data;

/**
 * project--community.
 * Create by zfl on 2020/2/23 20:05.
 **/
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
