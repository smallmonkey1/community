package com.z.community.enums;

/**
 * project--community.
 * Create by zfl on 2020/2/21 19:27.
 **/
public enum NotificationTypeEnum {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论")
    ;
    private int type;
    private String name;


    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String nameOfType(int type){
        for (NotificationTypeEnum value : NotificationTypeEnum.values()) {
            if (value.getType()==type) {
                return value.getName();
            }
        }
        return "";
    }
}
