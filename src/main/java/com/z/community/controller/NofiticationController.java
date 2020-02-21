package com.z.community.controller;

import com.z.community.dto.NotificationDTO;
import com.z.community.enums.NotificationTypeEnum;
import com.z.community.model.User;
import com.z.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * project--community.
 * Create by zfl on 2020/2/21 22:51.
 **/
@Controller
public class NofiticationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String a(
            HttpServletRequest req,
            @PathVariable(name = "id")Long id
    ){
        User user =(User) req.getSession().getAttribute("user");
        if (user==null) {
            return "redirect:/";
        }

        NotificationDTO notificationDTO = notificationService.read(id,user);
        if (NotificationTypeEnum.REPLY_COMMENT.getType()==notificationDTO.getType()
            ||NotificationTypeEnum.REPLY_QUESTION.getType()==notificationDTO.getType()) {
            return "redirect:/question/"+notificationDTO.getOuterid();
        }else{
            return "redirect:/";
        }

    }
}
