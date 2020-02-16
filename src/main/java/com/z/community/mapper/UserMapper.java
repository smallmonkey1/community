package com.z.community.mapper;

import com.z.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * project--community.
 * Create by zfl on 2020/2/12 19:31.
 **/

@Mapper
public interface UserMapper {

    @Insert(value = {"insert into USER (name,account_id,token,gmt_create,gmt_modified,avatar_url) " +
            "values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})"})
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id")Integer id);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId")String accountId);


    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(User dbUser);
}
