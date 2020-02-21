package com.z.community.enums;

/**
 * project--community.
 * Create by zfl on 2020/2/21 20:52.
 **/
public enum  NotificationStatusEnum {
    UNREAD(0),READ(1)
    ;
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
