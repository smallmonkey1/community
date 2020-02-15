package com.z.community.mapper;

import com.z.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * project--community.
 * Create by zfl on 2020/2/12 23:41.
 **/
@Mapper
public interface QuestionMapper {

    @Insert(value = {"insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description}" +
            ",#{gmtCreate},#{gmtModified},#{creator},#{tag})"})
    void create(Question question);

    @Select(value = {"select * from question limit #{offset},#{size}"})
    List<Question> list(
            @Param(value = "offset")Integer offset,
            @Param(value = "size") Integer size
    );


    @Select(value = {"select count(1) from question;"})
    Integer count();

    @Select(value = {"select * from question where creator=#{userId} limit #{offset},#{size}"})
    List<Question> listByUserId(
            @Param(value = "userId")Integer userId,
            @Param(value = "offset")Integer offset,
            @Param(value = "size") Integer size
    );

    @Select(value = {"select count(1) from question where creator=#{userId};"})
    Integer coutByUserId(@Param(value = "userId")Integer userId);
}
