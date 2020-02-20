package com.z.community.controller;

import com.z.community.dto.QuestionDTO;
import com.z.community.model.Question;
import com.z.community.model.User;
import com.z.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * project--community.
 * Create by zfl on 2020/2/12 22:59.
 **/
@Controller
public class PublishController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(
            @PathVariable(name = "id") Long id,
            Model model
    ){
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false)String title,
            @RequestParam(value = "description",required = false)String description,
            @RequestParam(value = "tag",required = false)String tag,
            @RequestParam(value = "id",required = false)Long id,
            HttpServletRequest req,
            Model model
    ){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        String e="";
        boolean b = (title == null || title.equals(""));
        if (b) {
            e=e+"标题不能为空；";
        }
        boolean de = (description == null || description.equals(""));
        if (de) {
            e=e+"问题不能为空；";
        }
        boolean b1 = (tag == null || tag.equals(""));
        if (b1) {
            e=e+"标签不能为空；";
        }
        if (b || de || b1) {
            model.addAttribute("error",e);
            return "publish";
        }

        User user = (User) req.getSession().getAttribute("user");
        if (user==null) {
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);

        questionService.createOrUpdate(question);
        return "redirect:/";
    }
}
