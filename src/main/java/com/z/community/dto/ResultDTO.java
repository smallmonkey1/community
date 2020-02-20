package com.z.community.dto;

import com.z.community.exception.CustomizeErrorCode;
import com.z.community.exception.CustomizeException;
import lombok.Data;

/**
 * project--community.
 * Create by zfl on 2020/2/17 23:45.
 **/
@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO errorOf(Integer code,String message){

        ResultDTO dto = new ResultDTO();
        dto.setCode(code);
        dto.setMessage(message);
        return dto;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage() );
    }

    public static ResultDTO okOf(){
        ResultDTO dto = new ResultDTO();
        dto.setCode(200);
        dto.setMessage("请求成功");
        return dto;
    }

    public static ResultDTO errorOf(CustomizeException ex) {
        return errorOf(ex.getCode(),ex.getMessage());
    }

    public static <T> ResultDTO okOf(T t){
        ResultDTO dto = new ResultDTO();
        dto.setCode(200);
        dto.setMessage("请求成功");
        dto.setData(t);
        return dto;
    }
}
