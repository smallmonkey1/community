package com.z.community.controller;

import com.z.community.dto.CommentCreateDTO;
import com.z.community.dto.CommentDTO;
import com.z.community.dto.ResultDTO;
import com.z.community.enums.CommentTypeEnum;
import com.z.community.exception.CustomizeErrorCode;
import com.z.community.model.Comment;
import com.z.community.model.User;
import com.z.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * project--community.
 * Create by zfl on 2020/2/17 23:17.
 **/
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    /*
    * @RequestBody:自动转成json
    * @ResponseBody:自动转成json
    * */
    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(
            @RequestBody CommentCreateDTO commentCreateDTO,
            HttpServletRequest req
            ){
        User user =(User) req.getSession().getAttribute("user");
        if (user==null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        if (commentCreateDTO==null || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }

        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment,user);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}",method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(
            @PathVariable(name = "id")Long id
    ){
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

}
