package com.z.community.mapper;

import com.z.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * project--community.
 * Create by zfl on 2020/2/12 19:31.
 **/

@Mapper
public interface UserMapper {

    @Insert(value = {"insert into USER (name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})"})
    void insert(User user);

}
