package com.z.community.mapper;

import com.z.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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

    @Select(value = {"select * from question"})
    List<Question> list();
}
