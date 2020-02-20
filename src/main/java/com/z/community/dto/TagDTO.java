package com.z.community.dto;

import lombok.Data;

import java.util.List;

/**
 * project--community.
 * Create by zfl on 2020/2/20 23:02.
 **/
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
