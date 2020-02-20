package com.z.community.mapper;


import com.z.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment record);
}