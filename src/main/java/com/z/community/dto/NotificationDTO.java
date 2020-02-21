package com.z.community.dto;

import lombok.Data;

/**
 * project--community.
 * Create by zfl on 2020/2/21 21:11.
 **/
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;

}
